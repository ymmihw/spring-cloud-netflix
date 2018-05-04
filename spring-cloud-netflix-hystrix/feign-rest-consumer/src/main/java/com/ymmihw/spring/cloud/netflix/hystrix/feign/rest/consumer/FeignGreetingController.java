package com.ymmihw.spring.cloud.netflix.hystrix.feign.rest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeignGreetingController {
  @Autowired
  private GreetingClient greetingClient;

  @RequestMapping("/get-greeting/{username}")
  @ResponseBody
  public String getGreeting(Model model, @PathVariable("username") String username) {
    return greetingClient.greeting(username);
  }
}
