ThisBuild / version := """0.1.0-SNAPSHOT"""

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "SBT",
    idePackagePrefix := Some("com.knoldus.SBT")
  )

lazy val core = (project in file("core"))
  .settings(
    name := "core",
    idePackagePrefix := Some("com.knoldus.SBT"),
    //Add scala test dependency in core module with test scope.
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
  ).dependsOn(utils)

lazy val utils = (project in file("utils"))
  .settings(
    name := "utils",
    idePackagePrefix := Some("com.knoldus.SBT")
  )


// Joda-datetime library

libraryDependencies += "joda-time" % "joda-time" % "2.12.2"
libraryDependencies += "org.joda" % "joda-convert" % "2.2.2"

//jdbc Dependency

libraryDependencies +="io.snappydata" % "snappydata-jdbc_2.11" % "1.3.1"

//Cached Resolution

updateOptions := updateOptions.value.withCachedResolution(true)

