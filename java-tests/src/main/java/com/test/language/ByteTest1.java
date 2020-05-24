package com.test.language; /*
                                *  @author Andrey Krutogolov
                                */

public class ByteTest1 extends ByteTest {
  @Override
  public void setByte(byte b) {
    System.out.println("ByteTest1::setByte()");
    this.b = b;
  }

  public static void main(String[] args) {
    ByteTest bt = new ByteTest();
    bt.setByte((byte) 1);

    System.out.println(bt.b);
  }
}
