package com.test.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/** @author Andrey Krutogolov */
public class MyObject {
  private volatile Book whatImReading;

  private static final AtomicReferenceFieldUpdater<MyObject, Book> updater =
      AtomicReferenceFieldUpdater.newUpdater(MyObject.class, Book.class, "whatImReading");

  public Book getWhatImReading() {
    return whatImReading;
  }

  public void setWhatImReading(Book whatImReading) {
    // this.whatImReading = whatImReading;
    updater.compareAndSet(this, this.whatImReading, whatImReading);
  }
}
