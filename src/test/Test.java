package test;

import java.util.logging.*;

public class Test {
  static {
    String path = Test.class.getClassLoader().getResource("logging.properties").getFile();
    System.setProperty("java.util.logging.config.file", path);
  }

  private static final Logger log = Logger.getLogger(Test.class.getName());
  public static void main(String[] args) {

    log.info("From Test !!");

  }

}
