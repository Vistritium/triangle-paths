package trianglepaths

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Framing, Sink, StreamConverters}
import akka.stream.{ActorMaterializer, Materializer}
import akka.util.ByteString

import scala.concurrent.Await
import scala.io.StdIn
import scala.concurrent.duration._

object Main extends App {

  def readInput(): Seq[Seq[Int]] = {
    var nextLine = StdIn.readLine()
    var lines = Seq(nextLine)
    while (nextLine.nonEmpty) {
      nextLine = StdIn.readLine()
      lines = lines :+ nextLine
    }

    lines.filter(_.nonEmpty).map(_.split(" ").map(_.toInt))
  }


  val input = readInput()
  val result = Solve.solve(input)
  println(s"Minimal path is: ${result.mkString(" + ")} = ${result.sum}")


}
