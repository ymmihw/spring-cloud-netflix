package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCircuitBreaker
public class CircuitBreakerMain {
  public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(CircuitBreakerMain.class, args);
    MyService myService = ctx.getBean(MyService.class);
    int n = 5;
    for (int i = 0; i < n; i++) {
      myService.doSomething(i < 3 ? 0 : 2);
      TimeUnit.MILLISECONDS.sleep(200);
    }
    TimeUnit.SECONDS.sleep(2);
    System.out.println("-- final call --");
    myService.doSomething(2);
  }
}
