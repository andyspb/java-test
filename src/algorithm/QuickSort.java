package algorithm;

public class QuickSort {

  public static void quickSort(int[] a, int p, int r) {
    if (p < r) {
      int q = partition(a, p, r);
      quickSort(a, p, q);
      quickSort(a, q + 1, r);
    }
  }

  private static int partition(int[] arr, int p, int r) {

    int x = arr[p];
    int i = p - 1;
    int j = r + 1;

    while (true) {
      i++;
      while (i < r && arr[i] < x)
        ++i;
      --j;
      while (j > p && arr[j] > x)
        --j;

      if (i < j)
        swap(arr, i, j);
      else
        return j;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {

    int[] arr = {1, 3, 5, 6, 2, 8, 0};
    for (int a : arr) {
      System.out.print(a);
      System.out.print(' ');
    }
    System.out.print('\n');


    quickSort(arr, 0, arr.length - 1);

    for (int a : arr) {
      System.out.print(a);
      System.out.print(' ');
    }
    System.out.print('\n');

  }
}