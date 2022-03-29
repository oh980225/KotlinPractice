fun main() {
  ignoreNulls("String")
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
  when (score) {
    0 -> println("this is zero")
    1 -> println("this is one")
    2, 3 -> println("this is two or three")
  }

  // 아래와 같이 초기화에 사용하는 경우는 else가 꼭 필요!
  var b = when (score) {
    1 -> 1
    2 -> 2
    else -> -1
  }

  when (score) {
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

// 7. 반복문 (for / while)
fun forAndWhile() {
  val fruits = arrayListOf("Apple", "Banana", "Orange")

  // 리스트 내 순환
  for (name in fruits) {
    println(name)
  }

  // 이렇게 index랑 같이 가능!
  for ((index, name) in fruits.withIndex()) {
    println("${index}번째 학생 : ${name}")
  }

  var sum = 0
  // 1~10
  for (i in 1..10) {
    sum += i
  }

  println(sum)

  var stepSum = 0
  // 2씩 건너면서!
  for (i in 1..10 step 2) {
    stepSum += i
  }

  println(stepSum)

  var downToSum = 0
  // 10부터 1까지(10,9,8...1)
  for (i in 10 downTo 1) {
    downToSum += i
  }

  println(downToSum)

  var untilSum = 0
  // 1 <= i < 10
  for (i in 1 until 10) {
    untilSum += i
  }

  println(untilSum)

  var index = 0
  while (index < 10) {
    println("current Idx : ${index++}")
  }
}

// 8. Nullable / NonNull
fun nullCheck() {
  // Null Pointer Exception -> 컴파일 시점에 발견 불가 -> 런타임 시점에서야 알게 됨
  // 하지만 Kotlin에서는 컴파일 시점에 발견 가능
  // 기본적으로 NonNull, 하지만 ?를 통해 Nullable 표시 가능

  var name = "seungjae"
  var nullName: String? = null

  var nameInUpperCase = name.uppercase()
  // nullName이 null이면 그냥 저 전체가 null을 반환, 아니면 올바르게 수행하라는 의미
  var nullNameInUpperCase = nullName?.uppercase()

  println(nameInUpperCase)
  println(nullNameInUpperCase)

  // ?: 엘비스 연산자 -> null일 경우 null 반환이 아닌 뒤에 지정한 default 값을 반환
  val lastName: String? = null
  val fullName = name + (lastName ?: "No Last Name")
  println(fullName)

}

// !! -> nullable인 대상에 대해 컴파일러에게 그것이 null이 아님을 명시!
// 하지만 이럴 경우 만약 !!를 붙혔는데 null이면 NullPointerException!
// -> 정말 완전 확실하지 않은 경우 외엔, 지양하는 것이 좋다!
fun ignoreNulls(str: String?) {
  val mNotNull: String = str!!

  val email: String? = null
  // let -> email이 null 아니면 그 동작을 해라!
  email?.let {
    // email을 이 내부에서는 it으로 사용 가능
    println("my email is ${email}")
  }
}