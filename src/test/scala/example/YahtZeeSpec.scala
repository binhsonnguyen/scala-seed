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

  it should "give sumation if successful Full House else zero" in {
    YahtZee.fullhouse(List(1, 1, 2, 2, 2)) should be (8)
    YahtZee.fullhouse(List(3, 2, 3, 2, 2)) should be (12)
    YahtZee.fullhouse(List(1, 1, 2, 2, 3)) should be (0)
    YahtZee.fullhouse(List(1, 2, 2, 2, 3)) should be (0)
    YahtZee.fullhouse(List(1, 2, 2, 3, 3)) should be (0)
    YahtZee.fullhouse(List(6, 6, 6, 6, 6)) should be (0)
  }

  it should "give 20 if successful Large Straight else zero" in {
    YahtZee.largeStraight(List(2, 3, 4, 5, 6)) should be (20)
    YahtZee.largeStraight(List(2, 3, 4, 5, 5)) should be (0)
  }

  it should "give 15 if successful Small Straight else zero" in {
    YahtZee.smallStraight(List(1, 2, 3, 4, 5)) should be (15)
    YahtZee.smallStraight(List(2, 3, 4, 5, 6)) should be (0)
    YahtZee.smallStraight(List(1, 2, 3, 4, 4)) should be (0)
  }

}
