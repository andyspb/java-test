package com.test.bds;

import java.util.LinkedList;

public class Trade {

  private long time;
  private double price;
  private int size;
  private String exchange;
  private LinkedList<Trade> windowTrades;

  @Override
  public String toString() {
    return "exchange:" + exchange + " time:" + time + " price:" + price + " size:" + size;
  }

  public String toStringAll() {
    StringBuffer sb = new StringBuffer();
    for (Trade trade : windowTrades) {
      sb.append(trade.toString()).append('\n');
    }
    return sb.toString();
  }

  public void addWindowTrade(Trade trade, long window) {
    // trades only within a window
    if (trade.time < time + window) {
      // System.out.println("+ trade:" + trade);
      windowTrades.add(trade);
    }
  }

  public long getWindowTradesVolume() {
    long res = windowTrades.stream().mapToInt(trade -> trade.getSize()).sum();
    return res;
  }

  public long getWindowExchangeTradesVolume() {
    long res = 0;
    for (Trade trade : windowTrades) {
      if (null != exchange && exchange.equals(trade.getExchange())) {
        res += trade.getSize();
      }
    }
    return res;
  }

  public Trade(long time, double price, int size, String exchange) {
    this.time = time;
    this.price = price;
    this.size = size;
    this.exchange = exchange;

    this.windowTrades = new LinkedList<>();

    windowTrades.add(this);
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getExchange() {
    return exchange;
  }

  public void setExchange(String symbol) {
    this.exchange = symbol;
  }
}
