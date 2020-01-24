package com.hacker.warmup;

public class JumpingOnTheClouds {
  static int jumpingOnClouds(int[] c) {
    int jumps = -1;
    for (int i = 0; i < c.length; ++i, ++jumps) {
      if (i < c.length - 2 && c[i + 2] == 0) ++i;
    }
    return jumps;
  }

  public static void main(String[] args) {
    int[] s = new int[]{0,0,1,0,0,1,0};
    int c = jumpingOnClouds(s);
    System.out.println(c);
  }
}
