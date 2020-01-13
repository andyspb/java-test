import scala.annotation.tailrec

object TailRec {
  def main(args: Array[String]) {
    println(sum(5))

    println(tailSum(5, 0))
  }

  def sum(n: Int): Int = { // computes the sum of the first n natural numbers
    if (n == 0) {
      n
    } else {
      n + sum(n - 1)
    }
  }

  @tailrec // just to ensure at compile time
  def tailSum(n: Int, acc: Int = 0): Int = {
    if (n == 0) {
      acc
    } else {
      tailSum(n - 1, acc + n)
    }
  }
}
