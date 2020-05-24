package com.vital;

public class Multiply {
  // Легкую задачку спросили как умножить m *n если нет оператора умножения

  public static int multiply_iter(int a, int b) {
    int res = 0;
    boolean aMinus = a < 0;
    boolean bMinus = b < 0;
    for (int i = 0; i < Math.abs(a); ++i) {
      res += b;
    }
    return aMinus ^ bMinus ? -Math.abs(res) : Math.abs(res);
  }

  public static int multiply_rec(int a, int b) {
    if (a == 0 || b == 0) return 0;
    else if (b < 0) return -a + multiply_rec(a, b + 1);
    else return a + multiply_rec(a, b - 1);
  }

  public static double multiplierLog(int a, int b) {
    return Math.pow(10, (Math.log10(a) + Math.log10(b)));
  }

  public static void main(String[] args) {
    int a = 6;
    int b = -7;
    int res = multiply_iter(a, b);
    //    System.out.println(res);
    //    a = -6;
    //    b = 7;
    //    res = multiply_iter(a, b);
    //    System.out.println(res);
    //
    //    a = -6;
    //    b = -7;
    //    res = multiply_iter(a, b);
    //    System.out.println(res);
    //
    //    a = 6;
    //    b = 7;
    //    res = multiply_iter(a, b);
    //    System.out.println(res);

    a = 6;
    b = 7;
    res = multiply_rec(a, b);
    System.out.println(a + " x  " + b + " = " + res);

    a = -6;
    b = 7;
    res = multiply_rec(a, b);
    System.out.println(a + " x  " + b + " = " + res);

    a = 6;
    b = -7;
    res = multiply_rec(a, b);
    System.out.println(a + " x  " + b + " = " + res);

    a = -6;
    b = -7;
    res = multiply_rec(a, b);
    System.out.println(a + " x  " + b + " = " + res);
  }
}
