package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCircuitBreaker
public class CircuitBreakerMain {
  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(CircuitBreakerMain.class, args);
    MyService myService = ctx.getBean(MyService.class);
    System.out.println("-- calling doSomething(2) --");
    myService.doSomething(2);
    System.out.println("-- calling doSomething(0) --");
    myService.doSomething(0);
    System.out.println("-- calling doSomething(5) --");
    myService.doSomething(5);
    System.out.println("-- calling doSomething2(2) --");
    myService.doSomething2(2);
  }
}
