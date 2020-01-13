
import scala.collection.mutable

/**
 * @author andy
 */
object Collections {
  val list = List();

  def main(args: Array[String]) {
    val i: Int = 0

    def ++ = i + 1

    while (i < 10) {
      list :+ i
      //      i = i+1
    }

  }

}
