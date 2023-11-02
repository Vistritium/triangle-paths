package trianglepaths

import scala.collection.mutable

object Solve {

  private case class TrianglePath(
    currentValue: Int,
    traversed: List[Int]
  )

  def solve(triangle: Seq[Seq[Int]]): Seq[Int] = {

    def iter(aggr: List[TrianglePath], remaining: List[List[Int]]): TrianglePath = {
      if (remaining.isEmpty) aggr.head
      else if (aggr.isEmpty) {
        iter(remaining.head.map(elem => TrianglePath(elem, List(elem))), remaining.tail)
      } else {
        val current :: nextRemaining = remaining

        val nextAggr = current.zipWithIndex.map { case (element, i) =>
          val leftNode = aggr(i)
          val rightNode = aggr(i + 1)
          val smallerNode = Seq(leftNode, rightNode).minBy(_.currentValue)
          TrianglePath(
            element + smallerNode.currentValue,
            element :: smallerNode.traversed
          )
        }

        iter(nextAggr, nextRemaining)

      }
    }

    iter(List.empty, triangle.map(_.toList).reverse.toList).traversed

  }

}
