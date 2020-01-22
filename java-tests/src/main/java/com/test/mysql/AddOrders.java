package com.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddOrders {

  public static final String URL = "jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false";
  public static final String USER = "andy";
  public static final String PASSWORD = "andy";

  public static void main(String[] args) {
    ResultSet rs = null;
    Connection connection = null;
    Statement statement = null;

    String query = "";

    try {
      // The newInstance() call is a work around for some
      // broken Java implementations
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      connection = DriverManager.getConnection(URL, USER, PASSWORD);

      statement = connection.createStatement();

      int[] client_ids = {6, 7, 8, 9, 8, 8, 6};
      float[] prices = {5.2f, 3.0f, 2f, 2.9f, 6.3f, 1.1f, 1.8f};
      int[] qtys = {1100, 1120, 2100, 1500, 400, 1300, 200};

      for (int i = 0; i < client_ids.length; ++i) {
        query =
            "insert into orders (client_id, price,qty) values('"
                + client_ids[i]
                + "', '"
                + prices[i]
                + "','"
                + qtys[i]
                + "')";
        statement.executeUpdate(query);
      }

    } catch (Exception ex) {
      // handle any errors
      System.out.println("Exception: " + ex.getMessage());
    }
  }
}
