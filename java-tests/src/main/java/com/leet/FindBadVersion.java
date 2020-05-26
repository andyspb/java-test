package com.leet;

class VersionControl {
  boolean isBadVersion(int version) {
    return version >= 4;
  }
}

public class FindBadVersion extends VersionControl {
  // Given n = 5, and version = 4 is the first bad version.
  public int firstBadVersion(int i) {
    System.out.println(i);
    return i;
  }

  public static void main(String[] args) {
    //
    FindBadVersion fbv = new FindBadVersion();
    int res = fbv.firstBadVersion(5);
  }
}
