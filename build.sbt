name := "PlayRoot"

version := "1.0"

lazy val common = project

lazy val shapeless = project.dependsOn(common).settings {
  libraryDependencies ++= Seq("com.chuusai" %% "shapeless" % "2.2.5")
}

lazy val scalaz_learn = project.dependsOn(common).settings {
  libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.0"
}

lazy val test = project.dependsOn(common, macrosExtension)
lazy val ninetyNineScalaProblems = project.dependsOn(common)
lazy val algoChallenges = project.dependsOn(common)
lazy val taskSolving = project.dependsOn(common)
lazy val generalLearning = project.dependsOn(common).settings {
  libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
    "org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.4",
    "org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2")

}
lazy val macrosExtension = project.dependsOn(common).settings {
  scalacOptions += "-language:experimental.macros"     ;       // Doesn't seem to work.
  libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _)
  //scalacOptions ++= Seq("-language:experimental.macros")
}

scalaVersion in ThisBuild := "2.11.7"
