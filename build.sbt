ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "triangle-paths",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.6-0142603"
    )
  )
