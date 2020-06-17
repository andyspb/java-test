package com.leet.array;

public class ValidSudoku {
  //  Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according
  // to the following rules:
  //  Each row must contain the digits 1-9 without repetition.
  //  Each column must contain the digits 1-9 without repetition.
  //  Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length != 9 || board[0].length != 9) return false;
    return true;
  }

  public static void main(String[] args) {
    ValidSudoku vs = new ValidSudoku();
  }
}
