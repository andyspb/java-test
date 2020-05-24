package com.javatest.demo;

class Person {
  String name;

  Person(String name) {
    this.name = name;
  }

  void greeting() {
    System.out.println("Hello, " + name);
  }
}

public class Test {

  public static void main(String... args) {
    Person p1;
    p1 = new Person("Tom");
    Person p2 = p1;
    p1 = null;
    p2 .greeting();
  }
}
