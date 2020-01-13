package com.leet.others;

public class NumberOf1Bits {

  public int hammingWeight(int n) {
    int count = 0;
    while (n > 0) {
      count += n & 1;
      n >>= 1;
    }
    return count;
  }

  public int hammingWeightRec(int n) {
    if (n == 0) return 0;
    else return (n & 1) + hammingWeightRec(n >> 1);
  }

  public static void main(String[] args) {
    //
    NumberOf1Bits nob = new NumberOf1Bits();
    System.out.println(nob.hammingWeight(4));
  }
}
