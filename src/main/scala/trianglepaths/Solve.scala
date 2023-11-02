package trianglepaths

import scala.collection.mutable

object Solve {

  def solve(triangle: Seq[Seq[Int]]): Seq[Int] = {

    def iter(aggr: List[Int], remaining: List[List[Int]]): List[Int] = {
      if (remaining.isEmpty) aggr
      else if (aggr.isEmpty) {
        iter(remaining.head, remaining.tail)
      } else {
        val current :: nextRemaining = remaining

        val nextAggr = current.zipWithIndex.map { case (element, i) =>
          val leftNode = aggr(i)
          val rightNode = aggr(i + 1)
          element + Math.min(leftNode, rightNode)
        }

        iter(nextAggr, nextRemaining)

      }
    }

    iter(List.empty, triangle.map(_.toList).reverse.toList)

  }

}
