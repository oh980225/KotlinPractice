fun main() {
  helloWorld()

  println(add(5, 7))

  template()
}

// 1. 함수 -> fun
// 변수명 : 타입
// fun 함수명() : 타입
// 반환이 없는 경우 -> fun 함수명() : Unit -> 단 생략 가능 fun 함수명()

fun helloWorld() {
  println("Hello World!")
}

fun add(a: Int, b: Int): Int {
  return a + b
}

// 2. val vs var
// val = value -> 값, 불변, 상수
// var = variable -> 변수, 변할 수 있음
// 코틀린은 타입 추론을 해주기에 val a = 10 -> 이렇게 써도 무방
// 단 val인지 var인지는 명시 필요
// 그리고 초기화 하지 않은 경우, 즉 타입 추론을 할 수 없는 경우에는 타입을 명시해 줘야한다.

fun valAndVar() {
  val a: Int = 10
  var b: Int = 9

  val c = 100
  var name = "Seungjae"
}

// 3. String Template
// $, ${} 를 통해서 String 내 변수 사용
// ${} 내에서 간단한 연산 가능
// \$ 를 통해 따로 $출력 가능

fun template() {
  val name = "Seungjae"
  val lastName = "Oh"
  println("my name is $name")
  println("my name is ${name + lastName}, Good Morning~")
  println("${1 == 0}")
  println("this is 2\$man")
}

// 4. 조건식

fun maxBy(a: Int, b: Int): Int {
  if (a > b) {
    return a
  }

  return b
}

// if (a > b) a else b -> java에서 삼항연산자와 동일
fun maxBy2(a: Int, b: Int) = if (a > b) a else b

// when -> switch 같은 것
fun checkNum(score: Int) {
  when(score) {
    0 -> println("this is zero")
    1 -> println("this is one")
    2, 3 -> println("this is two or three")
  }

  // 아래와 같이 초기화에 사용하는 경우는 else가 꼭 필요!
  var b = when(score) {
    1 -> 1
    2 -> 2
    else -> -1
  }

  when(score) {
    in 90..100 -> println("Good!")
    in 10..80 -> println("So so")
    else -> println("OK")
  }
}

// 5. Expression vs Statement
// Expression -> 어떠한 과정을 통해 값을 만들면 Expression이다!
// Statement -> 그렇지 않은 경우, 그냥 이렇게 하라! 같은 것은 -> Statement
// 코틀린에서는 if, when 등을 Expression으로도, Statement로도 사용 가능!
// 코틀린에서 모든 함수는 Expression -> 반환형이 없는 함수도 사실은 Unit을 반환하기 때문!

// 6. Array and List
// Array (Mutable -> 수정 가능)
// List 1. List(수정 불가) 2. MutableList(수정 가능)

fun array() {
  val array = arrayOf(1, 2, 3)
  val list = listOf(1, 2, 3)

  val array2 = arrayOf(1, "str", 3.4f)
  val list2 = listOf(1, "str", 11L)
  array[0] = 3
  var result = list.get(0)

  // ArrayList는 대표적인 MutableList
  val arrayList = arrayListOf<Int>()
  arrayList.add(10)
  arrayList.add(20)
  arrayList.add(30)

  val anyList = arrayListOf<Any>()
  anyList.add(10)
  anyList.add("str")
  anyList.add(1L)
}




