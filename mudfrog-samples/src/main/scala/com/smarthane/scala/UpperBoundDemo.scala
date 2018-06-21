package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/20 15:59
	* @Description:  4,泛型：
	[B <: A] UpperBound 上界：B类型的上界是A类型，即B类型的父类是A类型
	[B >: A] LowerBound 下界：B类型的下界是A类型，即B类型的子类是A类型
	[B <% A] ViewBound 表示B类型要转换成A类型，需要一个隐式转换函数
	[B : A] ContextBound 需要一个隐式转换的值
	[-A, +B]
	  [-A] 逆变，作为参数类型。如果A是T的子类，那么C[T]是C[A]的子类
	  [+B] 协变，作为返回类型。如果B是T的子类，那么C[B]是C[T]的子类
	*/
class UpperBoundDemo[T <: Comparable[T]] {
	def select(first: T, second: T): T = {
		if (first.compareTo(second) > 0) first else second
	}
	
}

object UpperBoundDemo {
	def main(args: Array[String]): Unit = {
		
		val upperBoundDemo = new UpperBoundDemo[Goddess2]
		val g1 = new Goddess2("AA", 90)
		val g2 = new Goddess2("BB", 80)
		
		val res = upperBoundDemo.select(g1, g2)
		println(res.toString)
		
	}
}

class Goddess2(val name: String, val faceValue: Int) extends Comparable[Goddess2]  {
	override def compareTo(o: Goddess2): Int = {
		this.faceValue - o.faceValue
	}
	
	override def toString: String = "name: " + name +"; faceValue: " + faceValue
}
