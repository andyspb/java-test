package com.test.generic;

import java.util.List;

class Pair<T1, T2> {
  T1 object1;
  T2 object2;

  Pair(T1 one, T2 two) {
    object1 = one;
    object2 = two;
  }

  public T1 getFirst() {
    return object1;
  }

  public T2 getSecond() {
    return object2;
  }
}

class Utilities {
  public static <T> void fill(List<T> list, T val) {
    for (int i = 0; i < list.size(); i++) list.set(i, val);
  }
}

public interface Test {
  public static void main(String[] args) {
    Pair<Integer, String> pair = new Pair<Integer, String>(6, " Apr");
    System.out.println(pair.getFirst() + pair.getSecond());
  }
}
