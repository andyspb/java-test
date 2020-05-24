package com.test.sync;

import java.io.IOException;
import java.util.concurrent.Callable;

public class CallableSample implements Callable<String> {
  @Override
  @SuppressWarnings("unused")
  public String call() throws Exception {
    if (false) {
      throw new IOException("error during task processing");
    }
    System.out.println("task is processing");
    return "result ";
  }
}
