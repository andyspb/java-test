package com.javatest;

import com.javatest.atomic.Book;
import com.javatest.atomic.MyObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** @author Andrey Krutogolov */
public class AtomicExampleTest {
  private MyObject myObject;

  @Before
  public void setUp() {
    myObject = new MyObject();
    myObject.setWhatImReading(new Book("Java 2 From Scratch"));
  }

  @Test
  public void testUpdate() {
    myObject.setWhatImReading(new Book("Pro Java EE 5 Performance Management and Optimization"));
    Assert.assertEquals(
        "Incorrect book name",
        "Pro Java EE 5 Performance Management and Optimization",
        myObject.getWhatImReading().getName());
  }
}
