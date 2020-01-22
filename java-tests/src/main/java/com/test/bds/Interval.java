package com.test.bds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Interval {
  // Start and end time in milliseconds
  // Total shares quantity
  // Shares for each exchange
  private int start;
  private int end = 0;
  private int quantity = 0;
  private HashMap<String, Integer> exchangeQuantity = new HashMap<>();

  public Interval(int start) {
    this.start = start;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public int getQuantity() {
    return quantity;
  }

  public void addQuantity(int quantity) {
    this.quantity += quantity;
  }

  public void addExchangeQuantity(String exchange, int quantity) {
    if (exchangeQuantity.containsKey(exchange)) {
      exchangeQuantity.put(exchange, exchangeQuantity.get(exchange) + quantity);
    } else {
      exchangeQuantity.put(exchange, quantity);
    }
  }

  public String getExchangeQuantityLine() {
    String response = "";
    Iterator it = exchangeQuantity.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      response += "Exchange: " + pair.getKey() + " Quantity: " + pair.getValue() + "\n";
      it.remove();
    }
    return response;
  }

  public String getLineStart() {
    return TimeUnit.MILLISECONDS.toHours(start)
        + ":"
        + TimeUnit.MILLISECONDS.toMinutes(start) % 60
        + ":"
        + TimeUnit.MILLISECONDS.toSeconds(start) % 60
        + "."
        + start % 1000;
  }

  public String getLineEnd() {
    return TimeUnit.MILLISECONDS.toHours(end)
        + ":"
        + TimeUnit.MILLISECONDS.toMinutes(end) % 60
        + ":"
        + TimeUnit.MILLISECONDS.toSeconds(end) % 60
        + "."
        + end % 1000;
  }

  @Override
  public String toString() {
    return "Since: " + getLineStart() + " Till: " + getLineEnd() + " Shares: " + getQuantity();
  }
}
