// 9. Class
// 자바는 파일 내 public class가 하나만 존재할 수 있고 파일 명과 같아야하지만
// 코틀린은 그렇지 않다!
// 코틀린 클래스, 메서드는 기본적으로 final!

// class Human(val name: String = "Don't Know") -> 이런 식으로 주생성자 사용! -> 기본값도 줄 수 있음
// open을 통해서 상속 허용
// 오버라이드를 허용하고 싶은 메서드에도 open 필요
open class Human(val name: String = "Don't Know") {

  // 인스턴스 생성시 동작
  // 주생성자가 수행되며 인스턴스가 생성된 동시에 해당 블록도 수행
  init {
    println("New Human!!!")
  }

  // 주생성자에게 위임을 받아서 부생성자 생성가능!
  // 항상 init 블록 먼저 수행하고 constructor 수행
  // 주생성자를 먼저 실행하고 그것을 통해서 부생성자를 수행하기 때문인듯
  constructor(name: String, age: Int) : this(name) {
    println("my name is ${name}, and age is ${age}")
  }

  fun eating() {
    println("eat eat eat")
  }

  open fun singASong() {
    println("lalalala~");
  }
}

// 코틀린에서는 이렇게 상속!
// 코틀린에서도 class 상속은 1개만 가능!
class Korean : Human() {
  override fun singASong() {
    println("외국은~")
    super.singASong()

    println("한국은~")
    println("랄라라~")
    println("my name is ${name}")
  }
}

fun main() {
  val human = Human("Seungjae")
  val newHuman = Human()
  val ageHuman = Human("someone", 10)

  human.eating()

  println("this human's name is ${human.name}")
  println("this new human's name is ${newHuman.name}")

  println("---------------")

  val korean = Korean()
  korean.singASong()
}