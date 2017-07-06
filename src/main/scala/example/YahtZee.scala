package example

object YahtZee {
  def chance(ds: Seq[Int]): Int = ds.sum

  def yahtzee(ds: Seq[Int]): Int = if (ds.tail.forall(d => d == ds.head)) 50 else 0

}
