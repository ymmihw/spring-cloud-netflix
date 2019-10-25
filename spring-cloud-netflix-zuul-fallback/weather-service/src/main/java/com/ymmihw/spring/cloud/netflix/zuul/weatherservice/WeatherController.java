package com.ymmihw.spring.cloud.netflix.zuul.weatherservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

  @GetMapping("/today")
  public String getMessage() {
    return "It's a bright sunny day today!";
  }

}