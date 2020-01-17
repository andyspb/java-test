package com.high5games;

import java.util.LinkedList;

public class Game {
  private LinkedList<Frame> frames = new LinkedList<>();
  private boolean isValid = true;
  private Frame prevFrame = null;

  public static Game build(String gameStr) {
    if (gameStr == null || gameStr.length() < 23 ) {
      return null;
    }
    String[] games = gameStr.split("\\|\\|");
    if (games.length < 1 || games.length > 2) {
      System.out.println("An invalid game :" + gameStr);
      return null;
    }
    Game game = new Game(games[0]);
    if (!game.isValid) {
      return null;
    }
    if (games.length > 1 && games[1].length() > 0) {
      if (!game.addBonusFrame(games[1]))
        return null;
    }
    return game;
  }

  private Game(String usualFrames) {
    String[] frames = usualFrames.split("\\|");
    int counter = 0;
    for (String frameStr : frames) {
      ++counter;
      if ((counter < 10 && (frameStr == null || frameStr.length() < 1)) || counter > 11) {
        isValid = false;
        return;
      }
      Frame frame = new NormalFrame(frameStr);
      this.frames.add(frame);
      if (prevFrame != null) {
        prevFrame.next = frame;
      }
      prevFrame = frame;
    }
  }

  private boolean addBonusFrame(String ballsStr) {
    Frame frame = new BonusFrame(ballsStr);
    if (!frame.isValid()) {
      return  false;
    }
    frames.add(frame);
    if (prevFrame != null) {
      prevFrame.next = frame;
    }
    return true;
  }

  public int getScore() {
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
