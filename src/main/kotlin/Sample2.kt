// 1. Lambda
// 람다식은 우리가 마치 value처럼 다룰 수 있는 익명 함수
// 1) 메서드의 파라미터로 넘겨줄 수 있다.
// 2) return 값으 사용할 수 있다.

// [Lambda 기본정의]
// val Lambda: Type = {argument -> codeBody}

// (A) -> (B) => A타입을 넣고 B 타입을 리턴 받는다.
val square: (Int) -> (Int) = { number -> number * number }

// 이렇게도 쓸 수 있음! -> 컴파일러가 타입추론이 가능하게!
val square2 = { number: Int -> number * number }

val nameAge = { name: String, age: Int ->
  "My name is ${name}, Age is ${age}"
}

// 2. 확장 함수
val pizza: String.() -> String = {
  this + " Pizza is Good!"
}

fun extendString(name: String, age: Int): String {
  // this -> 확장함수를 콜하는 객체
  // 파라미터가 한개로 명확하기에 it 사용
  val introduceMyself: String.(Int) -> String = {
    "name is ${this}, age is ${it}"
  }

  return name.introduceMyself(age)
}

// 3. Lambda의 return
// input값은 여러개일 수 있기에 ()필요!
// output값은 항상 하나이기에 () 생략가능
val calculateGrade: (Int) -> String = {
  when(it) {
    in 0..40 -> "fail"
    in 41..70 -> "pass"
    in 71..100 -> "perfect"
    else -> "Not Valid"
  }
}

// 4. Lambda를 표현하는 여러가지 방법
fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
  return lambda(5.1234)
}

// 추가적으로 자바의 Functional interface를
// 코틀린에서 람다식을 이용해서 사용 가능!

fun main() {
  println(square(5))
  println(nameAge("Seungjae", 25))
  val a = "Man1 said"
  val b = "Man2 said"

  println(a.pizza())
  println(b.pizza())
  println(extendString("Seungjae", 25))
  println(calculateGrade(101))

  val lambda = {number: Double ->
    number == 4.1234
  }

  println(invokeLambda(lambda))

  // Lambda 리터럴 방식
  // function의 마지막 parameter가 lambda일때 사용가능!
  println(invokeLambda { true })
  // 람다에 들어오는 parameter가 Double 1개이므로 it로 사용가능
  // 즉 이건 5.1234가 3.12보다 큰가!
  println(invokeLambda { it > 3.12 })

}