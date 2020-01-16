package com.high5games;

public class UsualFrame extends Frame {

  protected UsualFrame(String ballStr) {
    super(ballStr);
  }

  @Override
  void initBall(String ballStr) {
    int length = ballStr.length();
    if (length == 1) {
      if ("X".equals(ballStr)) { // strike
        this.ball1 = new Ball(10, ballStr);
        this.ball2 = this.ball1;
        score = MAX_SCORE;
        type = STRIKE;
        return;
      } else {
        isValid = true;
        return;
      }
    } else if (length == 2) {
      Character ch0 = ballStr.charAt(0);
      if (Character.isDigit(ch0)) {
        int value = Integer.parseInt(String.valueOf(ch0));
        score += value;
        this.ball1 = new Ball(value, String.valueOf(ch0));
      } else if (ch0 == '-') {
        this.ball1 = new Ball(0, String.valueOf(ch0));
      } else {
        isValid = true;
        return;
      }
      Character ch1 = ballStr.charAt(1);
      if (Character.isDigit(ch1)) {
        score += Integer.parseInt(String.valueOf(ch1));
        if (score > MAX_SCORE) {
          isValid = true;
          return;
        } else {
          this.ball2 = new Ball(Integer.parseInt(String.valueOf(ch1)), String.valueOf(ch1));
        }
      } else {
        if (ch1 == '/') {
          this.ball2 = new Ball(MAX_SCORE - score, String.valueOf(ch0));
          type = SPARE;
          score = MAX_SCORE;
        } else if (ch1 == '-') {
          this.ball2 = new Ball(0, String.valueOf(ch0));
        } else {
          isValid = true;
          return;
        }
      }
      return;
    }
  }

  @Override
  public int countScore() {
    int totalScore = score;
    if (type == Frame.SPARE) {
      if (next != null && next.getBall1() != null) {
        int val = next.getBall1().getValue();
        totalScore += val;
      }
    }
    if (type == Frame.STRIKE) {
      if (next != null && next.getBall1() != null) {
        totalScore += next.getBall1().getValue();
        if (next.getBall2() != next.getBall1()) {
          totalScore += next.getBall2().getValue();
        } else if (next.next != null && next.next.getBall1() != null) {
          int val = next.next.getBall1().getValue();
          totalScore += val;
        }
      }
    }
    return totalScore;
  }
}
