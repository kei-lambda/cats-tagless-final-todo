package com.keilambda.tftodo.core

trait TaskRepo[F[_], Id]:
  def getAll: F[Seq[Task]]
  def get(id: Id): F[Option[Task]]
  def add(data: Task): F[Task]
  def update(entity: Task): F[Option[Task]]
  def delete(id: Id): F[Option[Unit]]
