package com.leet.others;

public class HammingDistance {

  public int hammingDistance(int x, int y) {
    int n = x ^ y;
    int setBits = 0;
    while (n > 0) {
      setBits += n & 1;
      n >>= 1;
    }
    return setBits;
  }

  public static void main(String[] args) {
    //
    HammingDistance hd = new HammingDistance();
    int res = hd.hammingDistance(2, 4);
    System.out.println(res);
  }
}
