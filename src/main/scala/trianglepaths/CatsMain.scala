package trianglepaths

import cats.Monad
import cats.effect._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import cats.effect.std.Console

import scala.io.Source
import scala.util.Try
import cats.implicits._

object CatsMain extends IOApp {

  def parseTriangle(lines: Seq[String]): Try[Seq[Seq[Int]]] = {
    Try {
      lines.filter(_.nonEmpty).map(_.split(" ").toSeq.map(elem => elem.toInt))
    }
  }

  override def run(args: List[String]): IO[ExitCode] = {
    Resource.fromAutoCloseable(IO.delay(Source.stdin))
      .use { bs =>
        for {
          lines <- IO.delay(bs.getLines())
          triangle <- IO.fromTry(parseTriangle(lines.toList))
          result <- IO.delay(Solve.solve(triangle))
          _ <- Console[IO].println(s"Minimal path is: ${result.mkString(" + ")} = ${result.sum}")
        } yield ExitCode.Success
      }
  }
}
