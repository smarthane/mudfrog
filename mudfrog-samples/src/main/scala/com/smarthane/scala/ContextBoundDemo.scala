package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/21 9:35
	* @Description: [B : A] ContextBound
	*/
class ContextBoundDemo[T : Ordering] {
	
	def select(first: T, second: T): T = {
		val ord: Ordering[T] = implicitly[Ordering[T]]
		if (ord.gt(first, second)) first else second
	}
	
}

object ContextBoundDemo {
	
	def main(args: Array[String]): Unit = {
		
		import MyPredef.OrderingGirl2
		val contextBoundDemo = new ContextBoundDemo[Girl2]
		val g1 = new Girl2("AAA", 30, 80)
		val g2 = new Girl2("BBB", 25, 80)
	  val res =	contextBoundDemo.select(g1, g2)
		println(res.toString)
		
	}
	
}
