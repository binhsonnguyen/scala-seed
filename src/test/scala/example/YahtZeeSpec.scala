package example

import org.scalatest._

class YahtZeeSpec extends FlatSpec with Matchers {
  "chance" should "sumation value of dices" in {
    YahtZee.chance(List(1, 1, 1, 1, 1)) should be (5)
    YahtZee.chance(List(1, 1, 1, 1, 2)) should be (6)
    YahtZee.chance(List(6, 6, 6, 6, 6)) should be (30)
  }

  "yahtzee" should "give highest score (50) if yahtzee else zero" in {
    YahtZee.yahtzee(List(1, 1, 1, 1, 1)) should be (50)
    YahtZee.yahtzee(List(6, 6, 6, 6, 6)) should be (50)
    YahtZee.yahtzee(List(6, 6, 6, 6, 1)) should be (0)
  }
}
