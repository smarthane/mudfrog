
package com.smarthane.scala


class LazyDemo {

}

object LazyDemo {

  def init(): Unit = {
    println("call init")
  }

  def main(args: Array[String]): Unit = {
    lazy val property = init()  //lazy
    println("after init()")
    println(property)


  }

}


