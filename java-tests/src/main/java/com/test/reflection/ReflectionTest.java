package com.test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
  public static void main(String[] args) {
    Student s1 = new Student();

    // Getting hold of Class object created
    // by JVM.
    Class cls = s1.getClass();

    // Printing type of object using c1.
    System.out.println(cls.getName());

    // getting all methods in an array
    Method m[] = cls.getDeclaredMethods();
    for (Method method : m) System.out.println(method.getName());

    // getting all fields in an array
    Field f[] = cls.getDeclaredFields();
    for (Field field : f) System.out.println(field.getName());
  }
}

class Student {
  private String name;
  private int roll_No;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRoll_no() {
    return roll_No;
  }

  public void setRoll_no(int roll_no) {
    this.roll_No = roll_no;
  }
}
