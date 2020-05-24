package com.test.language; /*
                                *  @author Andrey Krutogolov
                                */

public class ByteTest {
  protected byte b;

  void setByte(byte b) {
    System.out.println("ByteTest::setByte()");
    this.b = b;
  }

  public static void main(String[] args) {
    byte b = 10;

    // Using b = b+1
    // b = b + 1; //Error:(11, 11) java: incompatible types: possible lossy conversion from int to
    // byte
    b++;
    System.out.println(b);

    /* Using typecasting will work
    b=(byte)b+1;
    System.out.println(b);*/
  }
}
