package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCircuitBreaker
public class CircuitBreakerMain2 {
  public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(CircuitBreakerMain2.class, args);
    MyService myService = ctx.getBean(MyService.class);

    System.out.println("-- calling doSomething(1) 40 times --");
    int n = 40;
    for (int i = 0; i < n; i++) {
      myService.doSomething(i < (n * 0.6) ? 0 : 2);
      TimeUnit.MILLISECONDS.sleep(100);
    }
    TimeUnit.SECONDS.sleep(6);

    System.out.println("-- final call --");
    myService.doSomething(2);
  }
}
