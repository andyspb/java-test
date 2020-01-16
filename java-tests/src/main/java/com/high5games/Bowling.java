package com.high5games;

// Write a program to score a game of Ten-Pin Bowling.
// X indicates a strike
// / indicates a spare
// - indicates a miss
// | indicates a frame boundary
// The characters after the || indicate bonus balls
//    X|X|X|X|X|X|X|X|X|X||XX
//    Ten strikes on the first ball of all ten frames.
//    Two bonus balls, both strikes.
//    Score for each frame == 10 + score for next two
//    balls == 10 + 10 + 10 == 30
//    Total score == 10 frames x 30 == 300
//
//    9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
//    Nine pins hit on the first ball of all ten frames.
//    Second ball of each frame misses last remaining pin.
//    No bonus balls.
//    Score for each frame == 9
//    Total score == 10 frames x 9 == 90
//
//    5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5
//    Five pins on the first ball of all ten frames.
//    Second ball of each frame hits all five remaining
//    pins, a spare.
//    One bonus ball, hits five pins.
//    Score for each frame == 10 + score for next one
//    ball == 10 + 5 == 15
//    Total score == 10 frames x 15 == 150
//
//    X|7/|9-|X|-8|8/|-6|X|X|X||81
//    Total score == 167

public class Bowling {

  public static void main(String[] args) {
    String[] gameStrs =
        new String[] {
          "X|X|X|X|X|X|X|X|X|X||XX", // ->330
          "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||", // ->90
          "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5", // 150
          "X|7/|9-|X|-8|8/|-6|X|X|X||81", // ->167
        };

    for (String gameStr : gameStrs) {
      String[] sGame = gameStr.split("\\|\\|");
      if (sGame.length < 1 || sGame.length > 2) {
        System.out.println("An invalid game :" + gameStr);
        System.exit(0);
      }
      Game game = new Game(sGame[0]);
      if (sGame.length > 1 && sGame[1].length() > 0) game.addBonusFrame(sGame[1]);

      if (game.isValid()) {
        int score = game.score();
        System.out.println("A score for the game:" + gameStr + " is:" + score);
      } else {
        System.out.println("An invalid game :" + gameStr);
      }
    }
  }
}
