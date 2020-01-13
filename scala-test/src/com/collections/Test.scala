package com.collections

object Test {
  def print_collection(a: Seq[Any]) {
    a.foreach(e => print("%s ".format(e)))
  }

  def main(args: Array[String]) {
    val numbers = Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    val s = Set(5, 1, 2, 3, 4)

    for (a <- numbers) {
      print("%s ".format(a))
    }

    println

    s.foreach(e => print("%s ".format(e)))

    println
    val f = Array("apple", "banana", "orange")
    f.foreach(e => print("%s ".format(e)))

    println
    val F = for (e <- f) yield e.toUpperCase
    F.foreach(e => print("%s ".format(e)))

    println
    print_collection(F)
  }

}

