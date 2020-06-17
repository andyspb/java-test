package com.leet.array;

import java.util.Arrays;

public class RotateImage {

//  You are given an n x n 2D matrix representing an image.
//  Rotate the image by 90 degrees (clockwise).

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] array= {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(Arrays.deepToString(array));
    RotateImage ri = new RotateImage();
    ri.rotate(array);
    System.out.println(Arrays.deepToString(array));

  }
}
