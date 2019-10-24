package com.ymmihw.spring.cloud.netflix.archaius;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArchaiusAdditionalSourcesLiveTest {

  private static final String BASE_URL = "http://localhost";

  @LocalServerPort
  private int port;

  private static final String DYNAMIC_PROPERTIES_URL = "/properties-from-dynamic";
  private static final Map<String, String> EXPECTED_ARCHAIUS_PROPERTIES =
      createExpectedArchaiusProperties();

  private static Map<String, String> createExpectedArchaiusProperties() {
    Map<String, String> map = new HashMap<>();
    map.put("baeldung.archaius.properties.one", "one FROM:other-config.properties");
    map.put("baeldung.archaius.properties.two", "two FROM:application.properties");
    map.put("baeldung.archaius.properties.three", "three FROM:config.properties");
    map.put("baeldung.archaius.properties.four", "four FROM:other-config.properties");
    return map;
  }

  @Autowired
  ConfigurableApplicationContext context;

  @Autowired
  private TestRestTemplate template;

  private <T> Map<T, T> exchangeAsMap(String uri,
      ParameterizedTypeReference<Map<T, T>> responseType) {
    return template.exchange(uri, HttpMethod.GET, null, responseType).getBody();
  }

  @Test
  public void givenNonDefaultConfigurationFilesSetup_whenRequestProperties_thenEndpointRetrievesValuesInFiles() {
    Map<String, String> initialResponse =
        this.exchangeAsMap(BASE_URL + ":" + port + DYNAMIC_PROPERTIES_URL,
            new ParameterizedTypeReference<Map<String, String>>() {});

    assertThat(initialResponse).containsAllEntriesOf(EXPECTED_ARCHAIUS_PROPERTIES);
  }
}
