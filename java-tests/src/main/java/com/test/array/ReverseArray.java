package com.test.array;

public class ReverseArray {

  public static void reverseArray(int[] array) {
    for (int i = 0; i < array.length >> 1; ++i) {
      int other = array.length - i - 1;
      int temp = array[i];
      array[i] = array[other];
      array[other] = temp;
    }
  }

  public static void main(String[] args) {
    System.out.println("ReverseArray >>>");

    int[] arr = {1, 2, 4, 7, 8, 9};
    printArray(arr);
    reverseArray(arr);
    printArray(arr);
  }

  public static void printArray(int[] array) {
    for (int a : array) {
      System.out.print(a + " ");
    }
    System.out.println();
  }
}
