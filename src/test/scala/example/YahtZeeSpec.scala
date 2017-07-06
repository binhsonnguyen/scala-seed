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

  it should "give sumation of Four of a Kind if match else zero" in {
    YahtZee.fourOfAKind(List(1, 1, 1, 1, 6)) should be (4)
    YahtZee.fourOfAKind(List(6, 6, 6, 6, 1)) should be (24)
    YahtZee.fourOfAKind(List(6, 6, 6, 1, 1)) should be (0)
  }

  it should "give sumation of Three of a Kind if match else zero" in {
    YahtZee.threeOfAKind(List(1, 1, 1, 6, 6)) should be (3)
    YahtZee.threeOfAKind(List(6, 6, 6, 1, 1)) should be (18)
    YahtZee.threeOfAKind(List(6, 6, 4, 1, 1)) should be (0)
    YahtZee.threeOfAKind(List(6, 6, 6, 6, 1)) should be (0)
    YahtZee.threeOfAKind(List(6, 6, 6, 6, 6)) should be (0)
  }

  it should "give sumation of Two Pair if match else zero" in {
    YahtZee.twoPair(List(1, 1, 2, 6, 6)) should be (14)
    YahtZee.twoPair(List(6, 6, 2, 5, 5)) should be (22)
    YahtZee.twoPair(List(6, 2, 2, 6, 6)) should be (0)
    YahtZee.twoPair(List(6, 6, 6, 6, 6)) should be (0)
    YahtZee.twoPair(List(1, 2, 3, 4, 5)) should be (0)
  }

  it should "give sumation of best Pair if match else zero" in {
    YahtZee.pair(List(1, 1, 2, 6, 6)) should be (12)
    YahtZee.pair(List(2, 2, 2, 5, 5)) should be (10)
    YahtZee.pair(List(1, 2, 3, 4, 6)) should be (0)
    YahtZee.pair(List(5, 4, 3, 2, 6)) should be (0)
  }

  it should "give sumation of line" in {
    YahtZee.aboveTheLine(List(4, 0, 0, 0, 0))(4) should be (4)
    YahtZee.aboveTheLine(List(4, 0, 4, 0, 0))(4) should be (8)
    YahtZee.aboveTheLine(List(4, 4, 4, 4, 4))(4) should be (20)
    YahtZee.aboveTheLine(List(1, 2, 3, 6, 5))(4) should be (0)

    YahtZee.aboveTheLine(List(4, 4, 4, 4, 4))(1) should be (0)
    YahtZee.aboveTheLine(List(6, 6, 6, 6, 6))(6) should be (30)
  }

}
