package com.ymmihw.spring.cloud.netflix.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class MyService {
  @HystrixCommand(fallbackMethod = "defaultDoSomething")
  public void doSomething(int input) {
    System.out.println("output: " + 10 / input);
  }

  public void defaultDoSomething(int input, Throwable throwable) {
    System.out.printf("Default, input=%s, exception=%s%n", input, throwable);
  }
}
