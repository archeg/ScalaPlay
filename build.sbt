name := "PlayRoot"

version := "1.0"

val scalazVersion = "7.2.0"

lazy val shapelessDep = Seq("com.chuusai" %% "shapeless" % "2.2.5")
lazy val scalazDep = Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  //"org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

lazy val swingDep = Seq("org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2")
lazy val parserDep = Seq("org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.4")
lazy val xmlDep = Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.4")
lazy val reflectDep = Seq("org.scala-lang" % "scala-reflect" % "2.11.7")

lazy val common = project.settings {
  libraryDependencies ++= (shapelessDep ++ reflectDep)
}

lazy val shapeless = project.dependsOn(common).settings {
  libraryDependencies ++= Seq("com.chuusai" %% "shapeless" % "2.2.5")
}

lazy val scalaz_learn = project.dependsOn(common).settings {
    scalacOptions ++= Seq("-language:implicitConversions", "-feature", "-language:higherKinds")
  }.settings {
    libraryDependencies ++= scalazDep
  }.settings {
  initialCommands in console := "import scalaz._, Scalaz._"
  }.settings {
  // For sbt test:console
  initialCommands in console in Test := "import scalaz._, Scalaz._, scalacheck.ScalazProperties._, scalacheck.ScalazArbitrary._,scalacheck.ScalaCheckBinding._"
}

lazy val test = project.dependsOn(common, macrosExtension)
lazy val ninetyNineScalaProblems = project.dependsOn(common)
lazy val algoChallenges = project.dependsOn(common)
lazy val taskSolving = project.dependsOn(common)
lazy val whyScala = project.dependsOn(common, macrosExtension).settings {
  libraryDependencies ++= parserDep ++ swingDep ++ scalazDep
}
lazy val generalLearning = project.dependsOn(common, macrosExtension).settings {
  libraryDependencies ++= parserDep ++ swingDep ++ xmlDep

}
lazy val macrosExtension = project.dependsOn(common).settings {
      scalacOptions += "-language:experimental.macros"
    }.settings {
      libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-reflect" % _)
    }

//scalacOptions in ThisBuild += "-feature"
scalaVersion in ThisBuild := "2.11.7"

