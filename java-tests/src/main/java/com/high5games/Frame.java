package com.high5games;

class Ball {
  public static String BAll_SYMBOLS = "123456789X/-";

  public static boolean isValidChar(char c) {
    return BAll_SYMBOLS.contains(String.valueOf(c));
  }

  private int value;
  private String strBall;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Ball(int v, String strBall) {
    this.value = v;
    this.strBall = strBall;
  }
}

abstract class Frame {
  public static String STRIKE = "STRIKE";
  public static String SPARE = "SPARE";

  protected static int MAX_SCORE = 10;

  protected boolean isValid = true;
  protected int score;

  protected Ball ball1;
  protected Ball ball2;

  protected String frameStr;
  protected String type;
  protected Frame next;

  protected Frame(String ballStr) {
    this.frameStr = ballStr;
    if (frameStr == null || frameStr.length() == 0 || frameStr.length() > 2) {
      isValid = false;
    }
    for (char c : ballStr.toCharArray()) {
      if (!Ball.isValidChar(c)) {
        isValid = false;
        break;
      }
    }
    initBall(ballStr);
  }

  abstract void initBall(String ballStr);

  public int countScore() {
    return 0;
  };

  public boolean isValid() {
    return isValid;
  }

  public Ball getBall1() {
    return ball1;
  }

  public Ball getBall2() {
    return ball2;
  }

  @Override
  public String toString() {
    return frameStr;
  }
}
