package com.amazon;

public class Game {
  public static final int UP = 0;
  public static final int DOWN = 1;
  public static final int LEFT = 2;
  public static final int RIGHT = 3;

  int length;
  int width;
  Grid grid;

  public Game() {
  }

  public void initGame(int w, int l) {
    width = w;
    length = l;
    grid = new Grid(width, length);
  }

  public void onTick() {

  }

  public void onKeyPress(int code) {
    switch (code) {
      case UP: rotate(); break;
      case DOWN: drop(); break;
      case LEFT: moveLeft(); break;
      case RIGHT: moveRight(); break;
      default:
        System.out.println("incorrect code.");
    }
  }

  private void rotate() {
    System.out.println("rotate");
  }

  private void moveLeft() {
    System.out.println("moveLeft");
  }
  private void moveRight() {
    System.out.println("moveRight");
  }

  private void moveDown() {
    System.out.println("moveDown");
  }

  public void drop() {
    System.out.println("drop");
  }
}
