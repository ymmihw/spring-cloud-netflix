package com.ymmihw.spring.cloud.netflix.hystrix;

import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MyService {

  @HystrixCommand(fallbackMethod = "defaultDoSomething", threadPoolKey = "myThreadPool")
  public void doSomething(int input) {
    System.out.printf("thread: %s, input: %s, output: %s%n", Thread.currentThread().getName(),
        input, 100 / input);
  }

  @HystrixCommand(fallbackMethod = "defaultDoSomething",
      threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "5"),
          @HystrixProperty(name = "maxQueueSize", value = "-1"),})
  public void doSomething2(int input) {
    System.out.printf("thread: %s, input: %s, output: %s%n", Thread.currentThread().getName(),
        input, 100 / input);
  }


  public void defaultDoSomething(int input, Throwable throwable) {
    System.out.printf("fallback, thread: %s input:%s, exception:%s%n",
        Thread.currentThread().getName(), input, throwable);
  }
}
