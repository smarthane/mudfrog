package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/14 10:28
	* @Description: apply 方法通常称为注入方法，在伴生对象时做一些初始化的操作
	*               apply 方法的参数列表不需要和构造器的参数列表统一
	*               unapply 方法通常称为提取方法，使用unapply方法来提取固定数量的对象
	*               unapply 方法会返回一个序列（Option），内部生成了一个Some对象来存放一些值
	*               apply 和 unapply会被隐式的调用 
	*/
class ApplyDemo(val name: String, var age: Int, var faceValue: Int) {
}

object ApplyDemo {
	
	//注入方法相当于做一些初始化
	def apply(name: String, age: Int, faceValue: Int): ApplyDemo = new ApplyDemo(name, age, faceValue)
	
	//提取方法
	def unapply(applyDemo: ApplyDemo): Option[(String, Int, Int)] = {
		if (applyDemo == null) {
			None
		} else {
			Some(applyDemo.name, applyDemo.age, applyDemo.faceValue)
		}
	}
}

object Test2 {
	def main(args: Array[String]): Unit = {
		val applyDemo = ApplyDemo("kobe", 30, 89)//调用 apply方法的固定方式 有参数列表一定是调用apply方法
		
		applyDemo match {
			case ApplyDemo("kobe", age, faceValue) => println(s"age:$age")
			case _ =>println("No match nothing")
		}
	}
}
