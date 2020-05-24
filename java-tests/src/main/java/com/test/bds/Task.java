package com.test.bds;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task {
  // Maximal interval and all intervals
  private Interval maxInterval;
  private List<Interval> intervals = new LinkedList<>();
  private String result = "";

  public static void main(String[] args) {
    Task example = new Task();
    example.doThing("TRD.csv");
    System.out.println(example.getResult());
  }

  public void doThing(String fileName) {
    try {
      // read every line in the file and perform manipulation
      Files.lines(Paths.get(fileName)).forEach(this::workWithLine);
      result += maxInterval + "\n" + maxInterval.getExchangeQuantityLine();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  private void workWithLine(String line) {
    // Split line on fields
    String[] tableLine = line.split(",");
    int quantity = Integer.valueOf(tableLine[2]), time = parseDate(tableLine[0]);

    // adding new interval with start time
    intervals.add(new Interval(time));
    for (Iterator<Interval> iterator = intervals.listIterator(); iterator.hasNext(); ) {
      Interval interval = iterator.next();
      // if new share happened in a second period summarize total and exchange quantities
      // set interval end time
      if (time - interval.getStart() <= 1000) {
        interval.addQuantity(quantity);
        interval.addExchangeQuantity(tableLine[3], quantity);
        interval.setEnd(time);
        // updating max interval
        if (maxInterval == null || maxInterval.getQuantity() < interval.getQuantity())
          maxInterval = interval;
      } else {
        // remove interval because it's won't change later
        iterator.remove();
      }
    }
  }

  public String getResult() {
    return result;
  }

  private int parseDate(String date) {
    return Integer.valueOf(date.substring(0, 2)) * 60 * 60 * 1000
        + Integer.valueOf(date.substring(3, 5)) * 60 * 1000
        + Integer.valueOf(date.substring(6, 8)) * 1000
        + Integer.valueOf(date.substring(9, 12));
  }
}
