package example

case class Rule(test: Int => Boolean, answer: String)

object FizzBuzz {

  val fizz = Rule(isFizz, "Fizz")
  val buzz = Rule(isBuzz, "Buzz")

  val rules: List[Rule] = List[Rule](fizz, buzz)


  def answer(n: Int): String = answerViaRules(n)

  private def answerViaRules(n: Int): String = {
    var buf = ""
    rules.foreach(r => {
      if (r.test(n)) buf += r.answer
    })
    if (buf.isEmpty) n.toString
    else buf
  }

  private def isFizz(n: Int): Boolean = n % 3 == 0

  private def isBuzz(n: Int): Boolean = n % 5 == 0

}
