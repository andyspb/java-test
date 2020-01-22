package com.test.bds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class CsvToTradeParcer {
  public static Trade parceCsv(String str) {
    long time = 0;
    double price = 0;
    int size = 0;
    String symbol = null;

    String[] values = new String[4];
    StringTokenizer tokenizer = new StringTokenizer(str, ",");
    int count = 0;
    while (count < 4 && tokenizer.hasMoreTokens()) {
      values[count++] = tokenizer.nextToken();
    }

    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
    Date date;
    try {
      date = formatter.parse(values[0]);
      time = date.getTime();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    price = Double.parseDouble(values[1]);
    size = Integer.parseInt(values[2]);
    symbol = values[3];

    Trade trade = new Trade(time, price, size, symbol);

    return trade;
  }
}
