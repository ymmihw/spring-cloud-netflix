package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCircuitBreaker
public class CircuitBreakerMain2 {
  public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext ctx = SpringApplication.run(CircuitBreakerMain2.class, args);
    MyService myService = ctx.getBean(MyService.class);

    System.out.println("Main Thread: " + Thread.currentThread().getName());
    System.out.println("-- calling doSomething(1) 20 times --");
    int n = 20;
    ExecutorService es = Executors.newFixedThreadPool(n);
    for (int i = 0; i < n; i++) {
      int finalI = i;
      es.submit(() -> myService.doSomething2(finalI + 1));
    }
    es.shutdown();
    es.awaitTermination(10, TimeUnit.SECONDS);

    TimeUnit.SECONDS.sleep(5);
    System.out.println("-- after 5 sec --");
    myService.doSomething2(5);

    TimeUnit.SECONDS.sleep(5);
    System.out.println("-- after 5 sec --");
    myService.doSomething2(2);
  }
}
