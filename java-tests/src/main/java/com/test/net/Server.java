package com.test.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {

  private static final Logger log = Logger.getLogger(Server.class.getName());

  public static void main(String[] args) throws IOException {

    log.info(" >>> main() Welcome to Server side");
    Server.run(5000);
  }

  public static void run(int port) throws IOException {
    log.info(" >>> run() on port:" + port);
    BufferedReader in = null;
    PrintWriter out = null;

    ServerSocket serverSocket = null;
    Socket fromclient = null;

    // create server socket
    try {
      serverSocket = new ServerSocket(port);

    } catch (IOException e) {
      System.out.println("Couldn't listen to port:" + port);
      System.exit(-1);
    }

    try {
      System.out.print("Waiting for a client...");
      fromclient = serverSocket.accept();
      System.out.println("Client connected");
    } catch (IOException e) {
      System.out.println("Can't accept");
      System.exit(-1);
    }

    in = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
    out = new PrintWriter(fromclient.getOutputStream(), true);
    String input, output;

    System.out.println("Wait for messages");
    while ((input = in.readLine()) != null) {
      if (input.equalsIgnoreCase("exit")) break;
      out.println("S ::: " + input);
      System.out.println(input);
    }
    out.close();
    in.close();
    fromclient.close();
    serverSocket.close();
    System.out.println("net.Server <<< exit run()");
  }
}
