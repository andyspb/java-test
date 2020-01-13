package com.test

class Point(var x: Int = 0, var y:Int = 0) {
  def move(dx: Int, dy: Int) : Unit = {
    x = x + dx
    y = y + dy
  }
  
  override def toString: String = s"($x,$y)"
}

object Point { 
  def main(args: Array[String]) {
    println("from main")
    val p = new Point(1,2)
    println(p)
    p.move(1, 2)
    println(p)
  }
}