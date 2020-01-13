package com.leet.sort;

public class FirstBadVersion extends VersionControl {

  public int firstBadVersion(int n) {
    if (n <= 0) {
      return n;
    }
    int start = 0;
    int end = n;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isBadVersion(mid) && mid - 1 >= 1 && !isBadVersion(mid - 1)) {
        return mid;
      } else if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return isBadVersion(start) ? start : end;
  }

  public static void main(String[] args) {
    //
    FirstBadVersion fb = new FirstBadVersion();
    int[] nums = new int[] {1, 2, 3, 4, 5, 6};
    int badVersion = fb.firstBadVersion(5);
    System.out.println(badVersion);
  }
}
