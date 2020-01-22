package com.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoadDriver {

  public static final String URL = "jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false";
  public static final String USER = "andy";
  public static final String PASSWORD = "andy";

  public static void main(String[] args) {
    ResultSet rs = null;
    Connection connection = null;
    Statement statement = null;

    String query = "SELECT * FROM clients";

    try {
      // The newInstance() call is a work around for some
      // broken Java implementations
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      connection = DriverManager.getConnection(URL, USER, PASSWORD);

      statement = connection.createStatement();
      rs = statement.executeQuery(query);

      while (rs.next()) {
        String id = "id:" + rs.getInt("id");
        String name = "name:" + rs.getString("name");
        String lastname = "lastname:" + rs.getString("lastname");
        String email = "email:" + rs.getString("email");
        String reg_date = "date:" + rs.getString("reg_date");

        String result = id + " " + name + " " + lastname + " " + email + " " + reg_date;

        System.out.println(result);
      }

    } catch (Exception ex) {
      // handle any errors
      System.out.println("Exception: " + ex.getMessage());
    }
  }
}
