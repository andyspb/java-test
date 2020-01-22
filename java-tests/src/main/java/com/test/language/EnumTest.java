package com.test.language;

enum Color {
  RED,
  GREEN,
  BLUE;
}

public class EnumTest {
  public static void main(String[] args) {
    Color arr[] = Color.values();

    for (Color col : arr) {
      System.out.println(col + " at index " + col.ordinal());
    }

    System.out.println(Color.valueOf("RED"));
  }
}
