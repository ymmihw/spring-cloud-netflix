package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCircuitBreaker
public class CircuitBreakerMain2 {
  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(CircuitBreakerMain2.class, args);
    MyThreadContext.createMyObject("test2");
    System.out.println("Main method. Thread: " + Thread.currentThread().getName());
    MyService myService = ctx.getBean(MyService.class);
    System.out.println("-- calling doSomething2() --");
    myService.doSomething2();
  }
}
