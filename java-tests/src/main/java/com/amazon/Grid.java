package com.amazon;

public class Grid {
  int width;
  int length;
  int[][] blocks;

  public Grid(int width, int length) {
    this.width = width;
    this.length = length;
    int[][] blocks = new int[width][length];
  }

  public boolean addPiece(Piece p) {

    return false;
  }

  public void checkCompressedLines() {

  }

}
