package com.leet.resursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an index k, return the kth row of the Pascal's triangle. For example, given k = 3, Return
 * [1,3,3,1].
 */

/** @author Andrey Krutogolov */
public class PascalTriangle2 {
  public List<Integer> getRow(int rowIndex) {
    if (rowIndex < 0) return new ArrayList<>();
    Integer[] ans = new Integer[rowIndex + 1];
    for (int level = 1; level <= rowIndex + 1; level++) {
      for (int row = level - 1; row >= 0; row--) {
        if (row == 0 || row == level - 1) ans[row] = 1;
        else {
          ans[row] = ans[row] + ans[row - 1];
        }
      }
    }
    return Arrays.asList(ans);
  }

  public static void main(String[] args) {
    PascalTriangle2 pt2 = new PascalTriangle2();
    List<Integer> res = pt2.getRow(3);
    System.out.println(res);
  }
}
