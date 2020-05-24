package com.test.binding;

class Animal {
  void eat() {
    System.out.println("animal is eating...");
  }

  String[] arr1;
  String[] arr2;
  String arr3[];
}

class Dog extends Animal {
  void eat() {
    System.out.println("dog is eating...");
  }

  static void method(Animal a) {
    if (a instanceof Dog) {
      Dog d = (Dog) a; // downcasting
      System.out.println("ok downcasting performed");
    }
  }

  public static void main(String args[]) {
    Animal a = new Dog();
    a.eat();

    Dog.method(a);
  }
}
