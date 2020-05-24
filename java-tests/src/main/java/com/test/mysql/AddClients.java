package com.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddClients {

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

      String[] names = {"vah", "ivan", "olga", "kris"};
      String[] lastnames = {"aar", "nitro", "was", "kas"};
      String[] emails = {"va@gmail.com", "34353453@hotmail.com", "ow@gmail.com", "kk@mail.ru"};

      for (int i = 0; i < names.length; ++i) {
        query =
            "insert into clients (name, lastname,email) values('"
                + names[i]
                + "', '"
                + lastnames[i]
                + "','"
                + emails[i]
                + "')";
        statement.executeUpdate(query);
      }

    } catch (Exception ex) {
      // handle any errors
      System.out.println("Exception: " + ex.getMessage());
    }
  }
}
