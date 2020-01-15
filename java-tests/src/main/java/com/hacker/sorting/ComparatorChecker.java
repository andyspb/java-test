package com.hacker.sorting;

import java.util.Arrays;
import java.util.Comparator;

class Player {
  public Player(String name, Integer score) {
    this.name = name;
    this.score = score;
  }

  public String name;
  public Integer score;

  @Override
  public String toString() {
    return name + ' ' + score;
  }
}

public class ComparatorChecker implements Comparator<Player> {
  @Override
  public int compare(Player a, Player b) {
    if (a.score < b.score) return 1;
    else if (a.score > b.score) return -1;
    else {
      return a.name.compareTo(b.name);
    }
  }

  public static void main(String[] args) {
    Player[] players =
        new Player[] {
          new Player("amy", 100),
          new Player("david", 100),
          new Player("heraldo", 50),
          new Player("aakansha", 75),
          new Player("aleksa", 150)
        };

    System.out.println(Arrays.toString(players));
  }
}
