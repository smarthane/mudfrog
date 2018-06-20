package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/15 10:17
	* @Description:
	*/
object ClassDemo {
	
	def main(args: Array[String]): Unit = {
		val human = new Human
		println(human.name)
		println(human.climb)
		println(human.fight)
	}
	
}

/**
	*特质 类似java的接口
	*
	*/
trait Flyable {
	
	// 声明一个没有值 的字段
	val distance: Int
	
	// 声明一个有值的字段
	val a: Int = 0
	
	// 声明一个没有实现 的方法
	def fight: String
	
	// 声明一个有实现 的方法
	def fly: Unit = {
		println("I can fly")
	}
	
}

/**
	* 抽象类
	*/
abstract class Animal {
	
	// 声明一个没有赋值的字段
	val name: String
	
	// 声明一个没有实现 的方法
	def run(): String
	
	// 声明一个有实现的方法
	def climb: String = {
		"I can climb"
	}
	
}

class Human extends Animal with Flyable {
	
	override val name: String = "kobe"
	
	// 重写了抽象类没有实现的方法
	override def run(): String = {
		 "I can run"
	}
	
	override val distance: Int = 100
	
	// 重写了特质中没有实现的方法
	override def fight: String = {
		 "I can fight"
	}
	
	// 重写了一个有实现的方法
	override def climb: String = "override climb"
	
}
