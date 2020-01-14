package com.hacker.algorithms.warmup;

public class TimeConversion {
  static String timeConversion(String s) {
    String tArr[] = s.split(":");
    String AmPm = tArr[2].substring(2, 4);
    int hh = Integer.parseInt(tArr[0]);
    int mm = Integer.parseInt(tArr[1]);
    int ss = Integer.parseInt(tArr[2].substring(0, 2));
    if (AmPm.equalsIgnoreCase("PM")) {
      if (hh < 12) hh += 12;
    } else if (AmPm.equalsIgnoreCase("AM") ) {
      if (hh == 12) hh = 0;
    }
    return String.format("%02d:%02d:%02d", hh, mm, ss);
  }

  public static void main(String[] args) {
//    String time12 = "07:05:45PM";
//    System.out.println(timeConversion(time12));
    String time2 = "12:45:45PM";
    System.out.println(timeConversion(time2));
  }
}
