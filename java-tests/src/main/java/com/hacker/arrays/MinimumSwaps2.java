package com.hacker.arrays;

public class MinimumSwaps2 {
  static int minimumSwaps(int[] arr) {
    int minSwap = 0;
    int hp = 0;
    int pos = arr.length;

    while (pos > 0) {
      // check each number and swap if the no muched
      if (arr[pos - 1] == pos) {
        // go to the next position becaus the position did not changed
        --pos;
      } else {
        // itterate and find where the number is and check the second number

        // find the position
        hp = pos;
        int brk = 1;

        while (hp > 0 && brk != 0) {
          if (arr[hp - 1] == pos) {
            // swap
            int temp = arr[pos - 1];
            arr[pos - 1] = arr[hp - 1];
            arr[hp - 1] = temp;
            brk = 0;
          } else {
            hp--;
          }
        }
        // count the swap
        minSwap++;
        // position decrement
        pos--;
      }
    }

    return minSwap;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {7, 1, 3, 2, 4, 5, 6};
    int swaps = minimumSwaps(arr);
    System.out.println(swaps);
  }
}
