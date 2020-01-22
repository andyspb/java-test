package com.test.algorithm;

/** @author Andrey Krutogolov */

// Given a square matrix,
// find if it’s a Toeplitz matrix or not. A Toeplitz (or diagonal-constant) matrix is a matrix
// in which each descending diagonal from left to right is constant, i.e., all elements in a
// diagonal are same.

//  Input: mat[N][N] = {{6, 7, 8, 9},
//                      {4, 6, 7, 8},
//                      {1, 4, 6, 7},
//                      {0, 1, 4, 6},
//                      {2, 0, 1, 4}};

public class ToeplitzMatrix {
  public static int ROWS = 5;
  public static int COLUMNS = 4;

  public static void main(String[] args) {
    int mat[][] = {{6, 7, 8, 9}, {4, 6, 7, 8}, {1, 4, 6, 7}, {0, 1, 4, 6}, {2, 0, 1, 4}};

    if (isToepliz(mat)) System.out.println("Matrix is a Toepliz ");
    else System.out.println("Matrix is not a Toepliz ");
  }

  static boolean isToepliz(int arr[][]) {
    // do for each element in first row
    for (int i = 0; i < COLUMNS; ++i) {
      // check descending diagonal starting from position (0, j) in the matrix
      if (!checkDiagonal(arr, 0, i)) return false;
    }

    // do for each element in first column
    for (int i = 1; i < ROWS; ++i) {
      // check descending diagonal starting from position (i, 0) in the matrix
      if (!checkDiagonal(arr, i, 0)) return false;
    }
    // we only reach here when each descending
    // diagonal from left to right is same
    return true;
  }

  static boolean checkDiagonal(int arr[][], int i, int j) {
    int element = arr[i][j];
    System.out.println(element);
    while (++i < ROWS && ++j < COLUMNS) {
      // mismatch found
      System.out.print(arr[i][j] + " ");
      if (arr[i][j] != element) {
        System.out.println();
        return false;
      }
    }
    System.out.println();
    // we only reach here when all elements
    // in given diagonal are same
    return true;
  }
}
