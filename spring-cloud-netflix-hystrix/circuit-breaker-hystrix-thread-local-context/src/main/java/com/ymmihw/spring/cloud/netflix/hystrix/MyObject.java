package com.ymmihw.spring.cloud.netflix.hystrix;

public class MyObject {
  private String name;

  public MyObject(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "MyObject{" + "name='" + name + '\'' + '}';
  }
}
