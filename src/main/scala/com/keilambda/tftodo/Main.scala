package com.keilambda.tftodo

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple:
  val run: IO[Unit] =
    for _ <- IO.println("hello, world")
    yield ()
end Main
