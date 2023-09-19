package com.keilambda.tftodo.core

enum Status:
  case Pending
  case Doing
  case Done
  case Abandoned

case class StatusRecord[A](pending: A, doing: A, done: A, abandoned: A)

case class Task(name: String, description: String, status: Status)
