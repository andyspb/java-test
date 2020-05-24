package com.test.test;

// Java program to demonstrate how serializing
// an object serializes other reference objects.

import java.io.*;

// Class Serial1 contains reference to object
// of class Serial2.
// implement Serilizable needs to avoid java.io.NotSerializableException
class Serial1 implements Serializable {
  private static final long serialVersionUID = 7828671870887122408L;
  Serial2 s2 = new Serial2();
}

// Class Serial2 contains reference to object
// of class Serial3.
class Serial2 implements Serializable {
  private static final long serialVersionUID = -1748387109234310410L;
  Serial3 s3 = new Serial3();
}

// A reference of this class is present in Serial2
class Serial3 implements Serializable {
  private static final long serialVersionUID = 1L;
  int i = 10;
  int j = 20;
}

public class DemoSerialize {

  public static void main(String args[]) throws Exception {
    Serial1 s1 = new Serial1();

    FileOutputStream fos = new FileOutputStream("abc.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(s1);

    fos.close();
    oos.flush();
    oos.close();

    FileInputStream fis = new FileInputStream("abc.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);

    Serial1 serobject = (Serial1) ois.readObject();

    fis.close();
    ois.close();

    System.out.println("Value of i after Serialization" + " is " + serobject.s2.s3.i);
    System.out.println("Value of j after Serialization" + " is " + serobject.s2.s3.j);
  }
}
