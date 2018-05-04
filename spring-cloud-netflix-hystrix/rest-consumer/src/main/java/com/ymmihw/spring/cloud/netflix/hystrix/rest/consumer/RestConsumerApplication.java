package com.ymmihw.spring.cloud.netflix.hystrix.rest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class RestConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(RestConsumerApplication.class, args);
  }
}
