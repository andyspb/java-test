package com.leet.math;
// Given an integer, write a function to determine if it is a power of three.
public class PowerOfThree {
  public boolean isPowerOfThree(int n) {
    if (n == 0) return false;
    return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
  }

  public boolean isPowerOfThreeRec(int n) {
    if (n == 0) return false;
    if (n == 1) return true;
    if (n > 1) return n % 3 == 0 && isPowerOfThreeRec(n / 3);
    else return false;
  }

  public boolean isPowerOfThreeIter(int n) {
    if (n == 1) return true;
    boolean result = false;
    while (n > 0) {
      int m = n % 3;
      if (m == 0) {
        n = n / 3;
        if (n == 1) return true;
      } else {
        return false;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //
    PowerOfThree pot = new PowerOfThree();
    int n = 27;
    boolean isPow3 = pot.isPowerOfThree(n);
    System.out.println(isPow3);
  }
}
