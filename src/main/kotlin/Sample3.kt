class Book private constructor(val id: Int, val name: String) {
  // companion object -> private property나 method를 불러올 수 있게 해줌!
  //  companion는 class 내부에 Companion이라는 정적(static) 객체를 생성
  companion object BookFactory : IdProvider {
    val myBook = "new book"

    fun create() = Book(getId(), "animal farm")

    override fun getId(): Int {
      return 5
    }
  }
}

interface IdProvider {
  fun getId(): Int
}

fun main() {
  // Book.Companion.create() -> Book.create() / Companion 생략 가능
  val book = Book.create()

  val booId = Book.BookFactory.getId()

  println("${book.id} ${book.name}")
}
