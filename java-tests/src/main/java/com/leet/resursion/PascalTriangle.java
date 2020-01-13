package com.leet.resursion;

import java.util.ArrayList;
import java.util.List;

/** @author Andrey Krutogolov */

// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
// Input: 5
//    Output:
//    [[1],
//   [1,1],
//  [1,2,1],
// [1,3,3,1],
// [1,4,6,4,1]]
public class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    if (numRows == 0) {
      return triangle;
    }
    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for (int rowNum = 1; rowNum < numRows; rowNum++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prevRow = triangle.get(rowNum - 1);
      row.add(1);
      for (int j = 1; j < rowNum; j++) {
        row.add(prevRow.get(j - 1) + prevRow.get(j));
      }
      // The last row element is always 1.
      row.add(1);
      triangle.add(row);
    }

    return triangle;
  }

  public static void main(String[] args) {
    int n = 5;
    PascalTriangle pt = new PascalTriangle();
    List<List<Integer>> list = pt.generate(n);
    for (List<Integer> sublist : list) {
      for (Integer i : sublist) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
