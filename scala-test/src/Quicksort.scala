

object QuickSort {

  def main(args: Array[String]) {
    println("MergeSort >>> ")
 
    val a1 = List[Int](11, 2, 12, 1, 0, 23, 7, 0, -2, 5)
    println(a1.mkString(" "))
    val l = sort(a1)
    println(l.mkString(" "))

    println("<<<")
  }

  def sort(list: List[Int]): List[Int] = {
    list match {
      case Nil => Nil
      case piv :: tail => {
        val (less, greater) = tail.partition(_ < piv)
        sort(less) ::: piv :: sort(greater)
      }
    }
  }

}