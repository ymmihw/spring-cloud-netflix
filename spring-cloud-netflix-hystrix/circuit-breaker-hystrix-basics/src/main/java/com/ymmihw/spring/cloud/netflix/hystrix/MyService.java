package com.ymmihw.spring.cloud.netflix.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class MyService {
  @HystrixCommand(fallbackMethod = "defaultDoSomething")
  public void doSomething(int input) {
    System.out.println("input: " + input);
    // in case of exception fallbackMethod is called
    System.out.println("output: " + 10 / input);
  }

  public void defaultDoSomething(int input) {
    System.out.println("in default method, the input number: " + input);
  }

  @HystrixCommand(fallbackMethod = "defaultDoSomething")
  public void doSomething2(int input) {
    try {
      TimeUnit.MILLISECONDS.sleep(1500);// timeout scenario
    } catch (InterruptedException e) {
      return;
    }
    System.out.println("input: " + input);
    System.out.println("output: " + 10 / input);
  }
}
