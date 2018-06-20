package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/15 10:02
	* @Description: 类名前加private[包名]关键字是指包访问权限 只有scale这个包可以访问
	*              构造器参数列表前加private是指伴生对象的权限，只有伴生对象才能访问
	*/
private[scala] class PrivateDemo private (val  gender: Int, var faceValue: Int) {
	
	// 字段前加private,些时该字段称为私有字段
	private val name: String = "kobe"
	
	// 对象私有字段，表示只能在本类访问
	private [this] var age: Int = 24
	
	private def sayHello(): Unit = {
		println(s"kobe's age is $age")
	}
	
}

object PrivateDemo {
	def main(args: Array[String]): Unit = {
		val p = new PrivateDemo(0, 90)
		p.sayHello()
	}
}
