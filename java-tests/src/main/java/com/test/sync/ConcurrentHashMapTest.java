package com.test.sync;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

  public static void main(String[] args) {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
    map.put(null, null);
  }
}
