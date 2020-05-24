package com.test.net;

import com.test.test.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientServerTest {

  static {
    String path = Test.class.getClassLoader().getResource("config/logging.properties").getFile();
    System.setProperty("java.util.logging.config.file", path);
  }

  private static final Logger log = Logger.getLogger(ClientServerTest.class.getName());

  public static final int PORT = 5000;

  public static void main(String... args) {
    log.setLevel(Level.FINE);

    log.info(" >>> main()");
    int port = PORT;

    Thread serverThread = new Thread(new ServerRun(port));
    serverThread.start();

    // Runtime.getRuntime().addShutdownHook(serverThread);

    Thread clientThread = new Thread(new ClientRun(port));
    clientThread.start();
  }
}

class ServerRun implements Runnable {
  private static final Logger log = Logger.getLogger(ServerRun.class.getName());

  private int port;

  public ServerRun(int port) {
    this.port = port;
  }

  public void run() {
    try {
      log.info("Thread " + Thread.currentThread().getId() + " is running");
      Server.run(port);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class ClientRun implements Runnable {
  private static final Logger log = Logger.getLogger(ClientRun.class.getName());

  private int port;

  public ClientRun(int port) {
    this.port = port;
  }

  public void run() {
    try {
      // Displaying the thread that is running
      log.info("Thread " + Thread.currentThread().getId() + " is running");
      ClientMultiNIC.run(port);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
