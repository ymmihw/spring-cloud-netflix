package com.ymmihw.spring.cloud.netflix.zuul.ui;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Ignore
public class LiveTest {

  @Test
  public void whenSendRequestToFooResource_thenOK() {
    final Response response = RestAssured.get("http://localhost:8080/foos/1");
    assertEquals(200, response.getStatusCode());
  }

  @Test
  public void whenSendRequest_thenHeaderAdded() {
    final Response response = RestAssured.get("http://localhost:8080/foos/1");
    assertEquals(200, response.getStatusCode());
    assertEquals("TestSample", response.getHeader("Test"));
  }
}
