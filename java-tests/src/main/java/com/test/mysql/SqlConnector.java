package com.test.mysql;

public class SqlConnector {
  private static volatile SqlConnector instance;

  private SqlConnector() {}

  public static SqlConnector getInstance() {
    if (null == instance) {
      synchronized (SqlConnector.class) {
        if (null == instance) {
          instance = new SqlConnector();
        }
      }
    }
    return instance;
  }
}
