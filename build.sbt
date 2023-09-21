val doobieVersion = "1.0.0-RC4"
val http4sVersion = "0.23.23"
val tapirVersion  = "1.7.4"

lazy val root = project
  .in(file("."))
  .settings(
    organization := "com.keilambda",
    name         := "tf-todo",
    version      := "0.0.0",
    scalaVersion := "3.3.0",
    libraryDependencies ++= Seq(
      "ch.qos.logback"               % "logback-classic"     % "1.4.11",
      "io.circe"                    %% "circe-generic"       % "0.15.0-M1",
      "org.typelevel"               %% "cats-core"           % "2.10.0",
      "org.typelevel"               %% "cats-effect"         % "3.5.1",
      "org.typelevel"               %% "log4cats-slf4j"      % "2.6.0",
      "org.tpolecat"                %% "doobie-core"         % doobieVersion,
      "org.tpolecat"                %% "doobie-postgres"     % doobieVersion,
      "org.http4s"                  %% "http4s-ember-server" % http4sVersion,
      "org.http4s"                  %% "http4s-dsl"          % http4sVersion,
      "org.http4s"                  %% "http4s-circe"        % http4sVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % tapirVersion,
      "com.softwaremill.sttp.tapir" %% "tapir-json-circe"    % tapirVersion
    )
  )
