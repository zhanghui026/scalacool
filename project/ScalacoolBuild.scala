import sbt._
import sbt.Keys._

object ScalacoolBuild extends Build {

  lazy val scalacool = Project(
    id = "scalacool",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scalacool",
      organization := "cn.scalacool",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"
      // add other settings here
    )
  )
}
