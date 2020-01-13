package com.leet.array;

// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
// The digits are stored such that the most significant digit is at the head of the list, and each
// element in the array contain a single digit.
// You may assume the integer does not contain any leading zero, except the number 0 itself.

import java.util.Arrays;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) return new int[0];
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      carry = sum >= 10 ? 1 : 0;
      digits[i] = sum % 10;
    }
    if (carry == 1) {
      int[] res = new int[digits.length + 1];
      System.arraycopy(digits, 0, res, 1, digits.length);
      res[0] = 1;
      return res;
    }
    return digits;
  }

  public static void main(String[] args) {
    PlusOne po = new PlusOne();
    // int[] digits = new int[]{4, 3, 2, 1};
    int[] digits = new int[] {9};
    int[] res = po.plusOne(digits);
    System.out.println(Arrays.toString(res));
  }
}
