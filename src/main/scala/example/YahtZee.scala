package example

object YahtZee {
  def chance(ds: Seq[Int]): Int = ds.sum

  def yahtzee(ds: Seq[Int]): Int = if (ds.tail.forall(d => d == ds.head)) 50 else 0

  def fullhouse(ds: Seq[Int]): Int = {
    val groupsCount = ds.groupBy(d => d).map(g => (g._1, g._2.size))
    if (groupsCount.count(g => g._2 == 2) == 1 && groupsCount.count(g => g._2 == 3) == 1) ds.sum else 0
  }

}
