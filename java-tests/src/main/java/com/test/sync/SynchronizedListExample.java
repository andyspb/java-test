package com.test.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedListExample {

  public static void main(String[] args) {

    List<String> syncList = Collections.synchronizedList(new ArrayList<String>());

    syncList.add("one"); // no need to synchronize here
    syncList.add("two");
    syncList.add("three");
    String str = syncList.get(0); // it is ok here => no need to synchronize

    // when iterating over a synchronized list, we need to synchronize access to the synchronized
    // list
    // because if you don't synchronize here, synchList maybe be changed during iterating over it
    synchronized (syncList) {
      Iterator<String> iterator = syncList.iterator();
      while (iterator.hasNext()) {
        System.out.println("item: " + iterator.next());
      }
    }
  }
}
