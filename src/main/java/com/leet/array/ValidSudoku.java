package com.leet.array;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length != 9 || board[0].length != 9)
      return false;
    return true;
  }

  public static void main(String[] args) {
    ValidSudoku vs = new ValidSudoku();
  }
}
