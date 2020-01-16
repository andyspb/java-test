package com.high5games;

import java.util.LinkedList;

public class Game {
  private LinkedList<Frame> frames = new LinkedList<>();

  private boolean isValid = true;
  Frame prevFrame = null;

  public Game(String usualFrames) {
    String[] frames = usualFrames.split("\\|");
    int counter = 0;
    for (String frameStr : frames) {
      ++counter;
      if ((counter < 10 && (frameStr == null || frameStr.length() < 1)) || counter > 11) {
        isValid = false;
        return;
      }

      Frame frame = new UsualFrame(frameStr);
      this.frames.add(frame);
      if (prevFrame != null) prevFrame.next = frame;
      prevFrame = frame;
    }
  }

  public void addBonusFrame(String ballsStr) {
    Frame frame = new BonusFrame(ballsStr);
    frames.add(frame);
    if (prevFrame != null) prevFrame.next = frame;
  }

  public int score() {
    if (!isValid) return -1;
    int totalScore = 0;
    for (Frame frame : frames) {
      totalScore += frame.countScore();
    }
    return totalScore;
  }

  public boolean isValid() {
    return isValid;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Frame frame : frames) {
      sb.append(frame).append("  ");
    }
    return sb.toString();
  }
}
