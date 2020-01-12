package com.leet.others;

public class ReverseBits {

  public int reverseBits(int n) {
    for (int i = 0; i < 16; i++) {
      n = swapBits(n, i, 32 - i - 1);
    }
    return n;
  }

  public int swapBits(int n, int i, int j) {
    int a = (n >> i) & 1;
    int b = (n >> j) & 1;

    if ((a ^ b) != 0) {
      return n ^= (1 << i) | (1 << j);
    }
    return n;
  }

  public static void main(String[] args) {
    // 00000010100101000001111010011100 -> 00111001011110000010100101000000
    // 43261596 -> 964176192
    ReverseBits rb = new ReverseBits();
    int n = 43261596;
    int res = rb.reverseBits(n);
    System.out.println(res);
    // -3 -> -1073741825
    n = -3;
    res = rb.reverseBits(n);
    System.out.println(res);
  }
}
