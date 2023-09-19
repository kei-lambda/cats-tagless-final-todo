package com.keilambda.tftodo.core

import cats.Functor

trait TaskService[F[_]: Functor]:
  def countStatus(status: Status)(using repo: TaskRepo[F, Int]): F[Int] =
    Functor[F].map(repo.getAll)(_.filter(_.status == status).length)

  def countByStatus(using repo: TaskRepo[F, Int]): F[StatusRecord[Int]] =
    Functor[F].map(repo.getAll)(
      _.foldRight(
        StatusRecord(
          pending = 0,
          doing = 0,
          done = 0,
          abandoned = 0
        )
      ) { (curr, acc) =>
        import Status.*
        curr.status match
          case Pending   => acc.copy(pending = acc.pending + 1)
          case Doing     => acc.copy(doing = acc.doing + 1)
          case Done      => acc.copy(done = acc.done + 1)
          case Abandoned => acc.copy(abandoned = acc.abandoned + 1)
      }
    )

  def groupByStatus(using repo: TaskRepo[F, Int]): F[StatusRecord[Array[Task]]] =
    Functor[F].map(repo.getAll)(
      _.foldRight(
        StatusRecord(
          pending = Array[Task](),
          doing = Array[Task](),
          done = Array[Task](),
          abandoned = Array[Task]()
        )
      ) { (curr, acc) =>
        import Status.*
        curr.status match
          case Pending   => acc.copy(pending = acc.pending :+ curr)
          case Doing     => acc.copy(doing = acc.doing :+ curr)
          case Done      => acc.copy(done = acc.done :+ curr)
          case Abandoned => acc.copy(abandoned = acc.abandoned :+ curr)
      }
    )
