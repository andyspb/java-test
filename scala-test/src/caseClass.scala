

abstract class Vehicle

case class Car(brand: String) extends Vehicle

case class Bike(brand: String, price: Long) extends Vehicle


object caseClass {
  def main(args: Array[String]) {
    val myCar = Car("BMW")
    println(myCar.toString())
  }
}
