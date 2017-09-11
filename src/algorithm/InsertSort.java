package algorithm;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertSort {

  private static final Logger log = Logger.getLogger(InsertSort.class.getName());

  public static void main(String[] args) {
    log.log(Level.INFO, ">>>");

    int arr[] = {12, 34, 54, 2, 3};
    System.out.println("Array before sorting");
    printArray(arr);

    log.log(Level.INFO, "<<<");

  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }


}
