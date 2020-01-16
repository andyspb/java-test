package com.high5games;

public class BonusFrame extends Frame {

  public BonusFrame(String ballStr) {
    super(ballStr);
  }

  @Override
  void initBall(String ballStr) {
    if (ballStr == null || ballStr.length() == 0 || frameStr.length() > 2) {
      isValid = false;
      return;
    }
    if (ballStr.length() == 1) {
      Character ch0 = frameStr.charAt(0);
      if (Character.isDigit(ch0)) {
        this.ball1 = new Ball(Integer.parseInt(String.valueOf(ch0)), ballStr);
      } else if ("X".equals(ballStr)) { // strike
        this.ball1 = new Ball(MAX_SCORE, ballStr);
        this.ball2 = this.ball1;
      } else {
        isValid = true;
        return;
      }
    } else if (ballStr.length() == 2) {
      Character ch0 = frameStr.charAt(0);
      if (Character.isDigit(ch0)) {
        this.ball1 = new Ball(Integer.parseInt(String.valueOf(ch0)), ballStr);
      } else if (ch0 == 'X') {
        this.ball1 = new Ball(MAX_SCORE, ballStr);
      } else if (ch0 == '-') {
        this.ball1 = new Ball(0, ballStr);
      } else {
        isValid = false;
        return;
      }
      Character ch1 = frameStr.charAt(1);
      if (Character.isDigit(ch1)) {
        int val = Integer.parseInt(String.valueOf(ch1));
        if (val + this.ball1.getValue() > MAX_SCORE) {
          isValid = false;
          return;
        }
        this.ball2 = new Ball(val, ballStr);
      } else if (ch0 == 'X') {
        this.ball2 = new Ball(MAX_SCORE, ballStr);
      } else if (ch0 == '-') {
        this.ball2 = new Ball(0, ballStr);
      } else if (ch0 == '/') {
        this.ball2 = new Ball(MAX_SCORE - this.ball1.getValue(), ballStr);
      } else {
        isValid = false;
        return;
      }
    }
  }
}
