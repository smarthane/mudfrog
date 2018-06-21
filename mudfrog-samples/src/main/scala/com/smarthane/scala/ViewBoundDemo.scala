package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/20 16:14
	* @Description: [B <% A] ViewBound 表示B类型要转换成A类型，需要一个隐式转换函数
	*/
class ViewBoundDemo[T <% Ordered[T]] {
	
	def select(first: T, second: T): T = {
		if (first > second) first else second
	}
	
}

object ViewBoundDemo {
	
	def main(args: Array[String]): Unit = {
		
		import MyPredef.selectGirl2
	  val viewBoundDemo =	new ViewBoundDemo[Girl2]
		val g1 = new Girl2("AA", 30, 80)
		val g2 = new Girl2("BB", 25, 80)
		val res = viewBoundDemo.select(g1, g2)
		println(res.toString)
	}
	
}
