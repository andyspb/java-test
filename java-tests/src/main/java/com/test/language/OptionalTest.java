package com.test.language;

import java.util.Optional;

public class OptionalTest {

  public static void main(String[] args) {
    //
    Optional<Integer> opt  =  Optional.ofNullable(null);

    System.out.println(opt.orElse(2));
  }
}
