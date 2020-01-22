package com.test.test;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServerTest {

  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/test", new TestHandler());
    server.createContext("/test2", new Test2Handler());
    server.setExecutor(null); // creates a default executor
    System.out.println("Starting server ... ");
    server.start();
  }

  static class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      System.out.println("Handle request >");
      String response = "This is the response";
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  static class Test2Handler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      System.out.println("Handle request >");
      String response = "This is the response";
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
}
