package example

import org.scalatest._

class FizzBuzzSpec extends WordSpec with Matchers {

  "FizzBuzz" when {
    "got an number chia het cho 3" should {
      "say Fizz" in {
        FizzBuzz.answer(3) shouldEqual "Fizz"
        FizzBuzz.answer(21) shouldEqual "Fizz"
      }
    }
    "got an number chia het cho 5" should {
      "say Fizz" in {
        FizzBuzz.answer(20) shouldEqual "Buzz"
      }
    }

    "got an number chia het cho 3 va 5" should {
      "say FizzBuzz" in {
        FizzBuzz.answer(15) shouldEqual "FizzBuzz"
      }
    }

    "else" should {
      "say number" in {
        FizzBuzz.answer(88) shouldEqual "88"
      }
    }
  }

}
