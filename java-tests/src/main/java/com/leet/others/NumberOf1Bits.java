package com.leet.others;

public class NumberOf1Bits {
  public boolean getBit(int n, int i) {
    return (n & (1 << i)) != 0;
  }

  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 1; i < 33; ++i) {
      if (true == getBit(n, i)) ++count;
    }
    return count;
  }

  public int hammingWeightRec(int n) {
    if (n == 0) return 0;
    else return (n & 1) + hammingWeightRec(n >> 1);
  }

  public static void main(String[] args) {
    NumberOf1Bits nob = new NumberOf1Bits();
    System.out.println(nob.hammingWeight(4));
  }
}
