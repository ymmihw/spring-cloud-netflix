package com.ymmihw.spring.cloud.netflix.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
@DefaultProperties
public class MyService {
  @HystrixCommand(fallbackMethod = "defaultDoSomething", commandKey = "doSomethingKey")
  public void doSomething(int input) {
    System.out.println("output: " + 10 / input);
  }

  public void defaultDoSomething(int input, Throwable throwable) {
    System.out.printf("fallback, input:%s, exception:%s%n", input, throwable);
  }
}
