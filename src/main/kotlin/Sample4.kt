// object는 프로그램이 실행 될 때 딱 하나의 인스턴스만 만들어진다!
// object -> singleton 패턴을 적용한 클래스!
object CarFactory {
  val cars = mutableListOf<Car>()

  fun makeCar(horsePower: Int): Car {
    val car = Car(horsePower)
    cars.add(car)
    return car
  }
}

data class Car(val horsePower: Int)

fun main() {
  val car = CarFactory.makeCar(10)
  val car2 = CarFactory.makeCar(200)

  println(CarFactory.cars.size)
  CarFactory.cars.forEach { c -> println(c) }
}