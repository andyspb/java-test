package com.test.bds;

import java.io.*;
import java.util.ArrayList;

// The attached file has data in the following format
// Time,PRICE,SIZE,EXCHANGE
// 10:00:00.009,135.14,100,V
// The line above should be read as 100 shares were sold for $135.14 at 10:00:00.009
// at the exchange "V".
// Please find the one second-window during which the largest number of trades took place.
// Do the same considering trades for each exchange separately.
// Your code will be evaluated based on its correctness, performance/computational complexity,
// and readability (feel free to comment your code and/or write a description).

// strategy
// Build sliding 10sec window for N and

public class FindOneSecondWindow {

  public static void main(String[] args) throws FileNotFoundException {
    String currentPath = System.getProperty("user.dir");
    currentPath = currentPath + "\\bin";
    System.out.println("currentPath: " + currentPath);
    String trdFile = currentPath + "\\trd.csv";
    FileInputStream fstream = new FileInputStream(trdFile);
    System.out.println("The file exists: " + trdFile);
    ArrayList<Trade> trades = new ArrayList<Trade>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
      String line;
      while ((line = br.readLine()) != null) {
        Trade trade = CsvToTradeParcer.parceCsv(line);
        // trades.add(trade);
        // test
        if ("P".equals(trade.getExchange())) {
          trades.add(trade);
        }
        // System.out.println(trade);
        // System.out.println(line);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // now add windows trades into each trade
    ArrayList<Trade> temp = trades;
    for (Trade tr : trades) {
      System.out.println(">>> Adding Window for trade : " + tr.toString());
      temp.forEach((tempTrade) -> tr.addWindowTrade(tempTrade, 1000));
    }

    Trade maxTradeWindow = trades.get(0);
    Trade maxExchangeTradeWindow = trades.get(0);
    for (Trade tr : trades) {
      if (tr.getWindowTradesVolume() > maxTradeWindow.getWindowTradesVolume()) {
        maxTradeWindow = tr;
      }
      // if (tr.getWindowExchangeTradesVolume() > maxExchangeTradeWindow
      // .getWindowExchangeTradesVolume()) {
      // maxExchangeTradeWindow = tr;
      // }
    }

    System.out.println(maxTradeWindow.toStringAll());
    System.out.println("=================================");
    // System.out.println(maxExchangeTradeWindow.toStringAll());

    try {
      fstream.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
