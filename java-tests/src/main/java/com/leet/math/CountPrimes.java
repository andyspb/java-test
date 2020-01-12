package com.leet.math;

// Count the number of prime numbers less than a non-negative number, n.
public class CountPrimes {
  public int countPrimes(int n) {
    boolean[] isPrime = new boolean[n];
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }
    // Loop's ending condition is i * i < n instead of i < sqrt(n)
    // to avoid repeatedly calling an expensive function sqrt().
    for (int i = 2; i * i < n; i++) {
      if (!isPrime[i]) continue;
      for (int j = i * i; j < n; j += i) {
        isPrime[j] = false;
      }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i]) {
        System.out.println(i);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // 10 -> 4
    int n = 10;
    CountPrimes cp = new CountPrimes();
    int countPrimes = cp.countPrimes(n);
    System.out.println("Number of primes:" + countPrimes);
  }
}
