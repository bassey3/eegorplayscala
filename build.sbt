name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"
val buildVersion = "0.12.0"

libraryDependencies += jdbc
libraryDependencies += cache
libraryDependencies += ws
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
libraryDependencies += "io.iron.ironmq" % "ironmq" % "0.0.17"
libraryDependencies += "org.reactivemongo" %% "play2-reactivemongo" % buildVersion
