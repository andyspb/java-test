
case class Person(firstName: String, lastName: String)

class A(val name: Char, val id: Int)

case class B(name: Char, id: Int)

object ClassTest {
  var count = 0

  def currentCount(): Long = {
    count += 1
    count
  }

  def main(args: Array[String]) {
    println("ClassTest >>> ")

    val me = Person("Daniel", "Spiewak")
    val first = me.firstName
    val last = me.lastName

    if (me == Person(first, last)) {
      println("Found myself!")
      println(me)
      println(me.hashCode())
    }

    val a1 = new A('a', 1)
    val a2 = new A('a', 1)
    println(a1 == a2) //this returns false

    var b1 = B('b', 1)
    var b2 = B('b', 1)
    println(b1 == b2) //this returns true

    println(ClassTest.currentCount())
    println(ClassTest.currentCount())
    println(ClassTest.currentCount())

  }
}
