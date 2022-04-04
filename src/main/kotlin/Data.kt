import java.time.LocalDate

// get 메서드, toString(), hashCode(), equals(), copy() 가 기본적으로 만들어짐
// 관련된 data class를 하나의 파일에 모아놓을 수도 있음
data class Ticket(val companyName: String, val name: String, var date: LocalDate, var seatNumber: Int)

fun main() {
  val ticketA = Ticket("대한 항공", "Seungjae", LocalDate.now(), 15)
  println(ticketA.date)
  println(ticketA)
}