package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/14 10:18
	* @Description:伴生对象：与类名相同并且用object修饰的对象叫做伴生对象
	*              类和其伴生对象之间可以相互访问私有方法和属性
	*/
class Dog {
	
	private var name: String = "erha"
	
	def printName():Unit = {
		//在Dog类中访问其伴生对象的私有属性
		println(Dog.CONSTANT + name)
	}
}

//伴生对象
object Dog {

	private val CONSTANT: String = "wangwang: "
	
	def main(args: Array[String]): Unit = {
		val d = new Dog
		//访问类的私有字段name
		println(d.name)
		d.name="hahak"
		d.printName()
	}
}
