


object GFG {
  def main(args: Array[String]) {
    test()

  }

  def findGrandparents(family: Map[String, Set[String]]): Map[String, Set[String]] = {
    family.foldLeft(Map[String, Set[String]]()) {
      case (grandParents, oneFamily) => {
        val grandChildren: Set[String] = oneFamily._2.flatMap(member => family.get(member)).flatten
        val res = grandChildren.map(child => {
          grandParents.get(child) match {
            case None => (child -> Set(oneFamily._1))
            case Some(x) => (child -> (x + oneFamily._1))
          }
        }).toMap
        grandParents ++ res
      }
    }
  }

  def test() {
    val input = Map("A" -> Set("B", "C"), "B" -> Set("D", "C"), "C" -> Set("E"))
    val output = findGrandparents(input)
    print(output)
  }

}
