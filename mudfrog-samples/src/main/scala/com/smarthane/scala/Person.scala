package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/14 9:19
	* @Description: 声明类时不需要加public关键字，默认就是public
	*              一个类文件可以声明多个类
	*/
class Person {
	
	// 用val修饰的变量是只读的不可修改，相当于只有get方法没有set方法
	val id: String = "100"
	// 用var修饰的变量相当于既有get又有set方法
	var name: String = _
	// 用private修饰的变量该变量属于对象私有变量，只有本类和伴生对象能访问到
	private var age: Int = _
	// 用private[this]修饰的变量该变量属于对象私有变量, 只有本类可以访问到，伴生对象也访问不到
	private[this] val gender = "man"
	
	
}



object Person {
	
	def main(args: Array[String]): Unit = {
		
		val p = new Person
		p.name = "kobe"
		p.age = 25
		println(p.id)
		println(p.name)
		println(p.age)
		
	}
	
}

object Test1 {
	
	def main(args: Array[String]): Unit = {
		val p = new  Person
		println(p.name)
	}
	
}
