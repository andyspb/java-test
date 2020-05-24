package com.test;

import com.test.atomic.Book;
import com.test.atomic.MyObject;
import org.junit.*;

/** @author Andrey Krutogolov */
public class AtomicExampleTest {
  private MyObject myObject;

  @BeforeClass
  public static void runOnceBeforeClass() {
    System.out.println("@BeforeClass - runOnceBeforeClass");
  }

  @AfterClass
  public static void runOnceAfterClass() {
    System.out.println("@AfterClass - runOnceAfterClass");
  }

  @Before
  public void setUp() {
    System.out.println("@Before - runBeforeTestMethod");
    myObject = new MyObject();
    myObject.setWhatImReading(new Book("Java 2 From Scratch"));
  }

  @After
  public void runAfterTestMethod() {
    System.out.println("@After - runAfterTestMethod");
  }

  @Test
  public void testUpdate() {
    System.out.println("@Test -testMethod");
    myObject.setWhatImReading(new Book("Pro Java EE 5 Performance Management and Optimization"));
    Assert.assertEquals(
        "Incorrect book name",
        "Pro Java EE 5 Performance Management and Optimization",
        myObject.getWhatImReading().getName());
  }
}
