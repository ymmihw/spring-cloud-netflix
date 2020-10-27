package com.ymmihw.spring.cloud.netflix.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class MyService {
  @HystrixCommand(fallbackMethod = "defaultDoSomething")
  public void doSomething() {
    System.out.println("doSomething(): Thread: " + Thread.currentThread().getName());
    MyObject myObject = MyThreadContext.getMyObject();
    System.out.printf("MyObject: %s%n", myObject);
  }

  @HystrixCommand(fallbackMethod = "defaultDoSomething", commandProperties = {
      @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")})
  public void doSomething2() {
    System.out.println("doSomething2(): Thread: " + Thread.currentThread().getName());
    MyObject myObject = MyThreadContext.getMyObject();
    System.out.printf("MyObject: %s%n", myObject);
  }

  public void defaultDoSomething(Throwable throwable) {
    System.out.printf("Fallback method, exception=%s%n", throwable);
  }
}
