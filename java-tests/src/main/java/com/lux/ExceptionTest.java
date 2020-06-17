package com.lux;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(print(1));
    }
    
    public static Exception print(int i) {
        if (i>0) {
            return new Exception("Test");
        } else {
            throw new RuntimeException();
        }
    } 
}
