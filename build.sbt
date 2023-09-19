lazy val root = project
  .in(file("."))
  .settings(
    organization := "com.keilambda",
    name         := "tf-todo",
    version      := "0.0.0",
    scalaVersion := "3.3.0",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core"   % "2.10.0",
      "org.typelevel" %% "cats-effect" % "3.5.1"
    )
  )
