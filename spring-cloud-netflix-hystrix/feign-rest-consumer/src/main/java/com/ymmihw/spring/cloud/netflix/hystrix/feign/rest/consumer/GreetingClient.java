package com.ymmihw.spring.cloud.netflix.hystrix.feign.rest.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import com.ymmihw.spring.cloud.netflix.hystrix.rest.producer.GreetingController;

@FeignClient(name = "rest-producer", url = "http://localhost:9090",
    fallback = GreetingClient.GreetingClientFallback.class)
public interface GreetingClient extends GreetingController {
  @Component
  public static class GreetingClientFallback implements GreetingClient {
    @Override
    public String greeting(@PathVariable("username") String username) {
      return "Hello User!";
    }
  }
}
