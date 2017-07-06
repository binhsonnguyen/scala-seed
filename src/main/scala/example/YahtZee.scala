package example

object YahtZee {
  def chance(ds: Seq[Int]): Int = ds.sum

  def yahtzee(ds: Seq[Int]): Int = if (ds.tail.forall(d => d == ds.head)) 50 else 0

  def fullhouse(ds: Seq[Int]): Int = {
    if (isFullHouse(ds)) ds.sum else 0
  }

  def largeStraight(ds: Seq[Int]): Int = if (straightUntilLast(of = ds)(from = 2) == 6) 20 else 0

  def smallStraight(ds: Seq[Int]): Int = if (straightUntilLast(of = ds)(from = 1) == 5) 15 else 0

  @annotation.tailrec
  private def straightUntilLast(of: Seq[Int])(from: Int): Int = of match {
    case last +: Seq() => if (from == last) from else 0
    case head +: tail => if (from == head) straightUntilLast(tail)(from + 1) else 0
    case _ => 0
  }

  private def isFullHouse(ds: Seq[Int]): Boolean = {
    val g = groupsAndCount(ds)
    g.size == 2 && (g.head._2 == 2 || g.head._2 == 3)
  }

  private def groupsAndCount(ds: Seq[Int]): Map[Int, Int] = ds.groupBy(d => d).map(g => (g._1, g._2.size))

}
