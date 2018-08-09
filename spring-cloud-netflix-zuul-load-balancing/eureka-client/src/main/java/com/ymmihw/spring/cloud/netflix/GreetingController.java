package com.ymmihw.spring.cloud.netflix;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
  @RequestMapping("/greeting")
  String greeting();
}
