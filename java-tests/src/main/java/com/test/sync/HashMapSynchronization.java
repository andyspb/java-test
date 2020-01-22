package com.test.sync;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapSynchronization {
  public static void main(String[] args) {
    // create map
    Map<String, String> map = new HashMap<String, String>();

    // populate the map
    map.put(null, null);
    map.put(Integer.toString(1), "ALIVE ");
    map.put("2", "IS");
    map.put("3", "AWESOME");

    // create a synchronized map
    Map<String, String> syncMap = Collections.synchronizedMap(map);

    System.out.println("Synchronized map :" + syncMap);
  }
}
