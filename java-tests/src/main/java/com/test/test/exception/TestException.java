package com.test.test.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class TestException extends Exception {

  private static final Logger log = Logger.getLogger(TestException.class.getName());

  public TestException() {
    super("Deafult message for TestException");
  }

  public TestException(String message) {
    super(message);
  }

  public TestException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public String getMessage() {
    return super.getMessage();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    log.log(Level.INFO, "Test exception");
    try {
      throw new TestException();
    } catch (Exception ex) {
      System.out.println("This is my custom exception:" + ex.getMessage());
    }
  }
}
