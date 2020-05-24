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

import java.util.Scanner;

public class Bowling {

  private static void runExamples() {
    System.out.println("Examples for games:");
    String[] examples =
        new String[] {
          "X|X|X|X|X|X|X|X|X|X||XX", // ->330
          "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||", // ->90
          "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5", // 150
          "X|7/|9-|X|-8|8/|-6|X|X|X||81", // ->167
        };
    for (String example : examples) {
      Game game = Game.build(example);
      if (game != null) {
        System.out.println("A score for the game:" + example + " is:" + game.getScore());
      } else {
        System.out.println("The invalid game :" + example);
      }
    }
  }

  private static void printHelpMessage() {
    System.out.println("Please enter a game that consists of ten frames and a bonus game");
    System.out.println("PEach frame consists of two balls, except a strike");
    System.out.println("A digit indicates one ball");
    System.out.println("X indicates a strike");
    System.out.println("/ indicates a spare");
    System.out.println("- indicates a miss");
    System.out.println("| indicates a frame boundary");
    System.out.println("The characters after the || indicate bonus balls");
    System.out.println("Example: X|7/|9-|X|-8|8/|-6|X|X|X||81");
    System.out.println();
  }

  public static void main(String[] args) {
    printHelpMessage();
    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();
    scanner.close();
    Game game = Game.build(str);
    if (game != null) {
      System.out.println("A score for the game:" + str + " is:" + game.getScore());
    } else {
      System.out.println("The invalid game :" + str);
      runExamples();
    }
  }
}
