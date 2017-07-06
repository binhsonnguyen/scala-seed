package example

object YahtZee {
  def chance(ds: Seq[Int]): Int = ds.sum

  def yahtzee(ds: Seq[Int]): Int = if (ds.tail.forall(d => d == ds.head)) 50 else 0

  def fullhouse(ds: Seq[Int]): Int = {
    if (isFullHouse(ds)) ds.sum else 0
  }

  private def isFullHouse(ds: Seq[Int]): Boolean = {
    val g = groupsAndCount(ds)
    g.size == 2 && (g.head._2 == 2 || g.head._2 == 3)
  }

  private def groupsAndCount(ds: Seq[Int]): Map[Int, Int] = ds.groupBy(d => d).map(g => (g._1, g._2.size))

}
