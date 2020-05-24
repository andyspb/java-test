package com.test.generic;

interface Parser<T> {
  T parse();
}

interface Iterator<E> {
  E next();

  boolean hasNext();
}

interface List<E> {
  void add(E x);

  Iterator<E> iterator();
}

class HasList<T extends List> {
  protected final T list;

  public HasList(T list) {
    this.list = list;
  }

  public T getList() {
    return list;
  }
}

public class GenericTest {
  public static void main(String[] args) {}
}
