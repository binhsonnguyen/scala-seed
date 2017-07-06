package example

import org.scalatest._

class YahtZeeSpec extends FlatSpec with Matchers {
  "score when chance" should " be sumation of all dice" in {
    YahtZee.chance(List(1, 1, 1, 1, 1)) should be (5)
    YahtZee.chance(List(1, 1, 1, 1, 2)) should be (6)
    YahtZee.chance(List(6, 6, 6, 6, 6)) should be (30)
  }

  "yahtzee" should "give highest score (50) if yahtzee else zero" in {
    YahtZee.yahtzee(List(1, 1, 1, 1, 1)) should be (50)
    YahtZee.yahtzee(List(6, 6, 6, 6, 6)) should be (50)
    YahtZee.yahtzee(List(6, 6, 6, 6, 1)) should be (0)
  }

  "fullhouse" should "give sumation if match" in {
    YahtZee.fullhouse(List(1, 1, 2, 2, 2)) should be (8)
    YahtZee.fullhouse(List(3, 2, 3, 2, 2)) should be (12)
  }

  it should "give zero if not a fullhouse" in {
    YahtZee.fullhouse(List(1, 1, 2, 2, 3)) should be (0)
    YahtZee.fullhouse(List(1, 2, 2, 2, 3)) should be (0)
    YahtZee.fullhouse(List(1, 2, 2, 3, 3)) should be (0)
    YahtZee.fullhouse(List(6, 6, 6, 6, 6)) should be (0)
  }

  "largeStraight" should "give 20 if match" in {
    YahtZee.largeStraight(List(2, 3, 4, 5, 6)) should be (20)
  }
  it should "give zero if unmatch" in {
    YahtZee.largeStraight(List(2, 3, 4, 5, 5)) should be (0)
  }

  "smallStraight" should "give 15 if match" in {
    YahtZee.smallStraight(List(1, 2, 3, 4, 5)) should be (15)
  }

  it should "give zero if unmatch" in {
    YahtZee.smallStraight(List(2, 3, 4, 5, 6)) should be (0)
    YahtZee.smallStraight(List(1, 2, 3, 4, 4)) should be (0)
  }

  "fourOfAKind" should "give sumation of Four of a Kind if match" in {
    YahtZee.fourOfAKind(List(1, 1, 1, 1, 6)) should be (4)
    YahtZee.fourOfAKind(List(6, 6, 6, 6, 1)) should be (24)
  }

  it should "give zero else" in {
    YahtZee.fourOfAKind(List(6, 6, 6, 1, 1)) should be (0)
  }

  "threeOfAKind" should "give sumation of Three of a Kind if match else zero" in {
    YahtZee.threeOfAKind(List(1, 1, 1, 6, 6)) should be (3)
    YahtZee.threeOfAKind(List(6, 6, 6, 1, 1)) should be (18)
  }

  it should "give zero else" in {
    YahtZee.threeOfAKind(List(6, 6, 4, 1, 1)) should be (0)
    YahtZee.threeOfAKind(List(6, 6, 6, 6, 1)) should be (0)
    YahtZee.threeOfAKind(List(6, 6, 6, 6, 6)) should be (0)
  }

  "twoPair" should "give sumation of Two Pair if match" in {
    YahtZee.twoPair(List(1, 1, 2, 6, 6)) should be (14)
    YahtZee.twoPair(List(6, 6, 2, 5, 5)) should be (22)
  }

  it should "give zero else" in {
    YahtZee.twoPair(List(6, 2, 2, 6, 6)) should be (0)
    YahtZee.twoPair(List(6, 6, 6, 6, 6)) should be (0)
    YahtZee.twoPair(List(1, 2, 3, 4, 5)) should be (0)
  }

  "pair" should "give sumation of best Pair if match else zero" in {
    YahtZee.pair(List(1, 1, 2, 6, 6)) should be (12)
    YahtZee.pair(List(2, 2, 2, 5, 5)) should be (10)
    YahtZee.pair(List(1, 2, 3, 4, 6)) should be (0)
    YahtZee.pair(List(5, 4, 3, 2, 6)) should be (0)
  }

  "aboveTheLine" should "give sumation of line" in {
    YahtZee.aboveTheLine(List(4, 0, 0, 0, 0))(4) should be (4)
    YahtZee.aboveTheLine(List(4, 0, 4, 0, 0))(4) should be (8)
    YahtZee.aboveTheLine(List(4, 4, 4, 4, 4))(4) should be (20)
    YahtZee.aboveTheLine(List(1, 2, 3, 6, 5))(4) should be (0)

    YahtZee.aboveTheLine(List(4, 4, 4, 4, 4))(1) should be (0)
    YahtZee.aboveTheLine(List(6, 6, 6, 6, 6))(6) should be (30)
  }

}
