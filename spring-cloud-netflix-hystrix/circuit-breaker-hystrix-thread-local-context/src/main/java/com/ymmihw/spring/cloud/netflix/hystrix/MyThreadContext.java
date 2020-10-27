package com.ymmihw.spring.cloud.netflix.hystrix;

public class MyThreadContext {
  private static final ThreadLocal<MyObject> threadLocal = new ThreadLocal<>();

  public static MyObject createMyObject(String name) {
    MyObject myObject = new MyObject(name);
    threadLocal.set(myObject);
    return myObject;
  }

  public static MyObject getMyObject() {
    return threadLocal.get();
  }
}
