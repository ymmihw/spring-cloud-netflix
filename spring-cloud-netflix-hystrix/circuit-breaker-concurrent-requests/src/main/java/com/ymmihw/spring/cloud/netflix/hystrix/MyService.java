package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyService {
  @HystrixCommand(fallbackMethod = "defaultDoSomething")
  public void doSomething(int input) {
    System.out.printf("thread: %s, input: %s, output: %s%n", Thread.currentThread().getName(),
        input, 100 / input);
  }

  public void defaultDoSomething(int input, Throwable throwable) {
    System.out.printf("fallback, thread: %s input:%s, exception:%s%n",
        Thread.currentThread().getName(), input, throwable);
  }
}
