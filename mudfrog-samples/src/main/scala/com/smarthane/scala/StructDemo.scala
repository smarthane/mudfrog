package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/14 9:41
	* @Description: 主构造器的参数列表 要放到类名的后面，和类名放在一起
	*              val修饰的构造参数具有不可变性，var修饰的构造参数具有可变性
	*              此时声明的faceValue: Int只能在本类调用 ，伴生对象也不法调用
	*              faceValue虽然没有用val或者var默认是用val修饰的，有默认值时new的时候 可以不传该参数
	*
	**/
//构造器
class StructDemo(val name: String, var age: Int, faceValue: Int = 90) { // 主构造器
	
	var gender: String = _
	
	def getFaceValue(): Int = {
	  //faceValue默认是用val修饰的，不可修改
		faceValue //最后一句的代码作为返回值
	}
	
	// 辅助构造器
	def this(name: String, age: Int, faceValue: Int, gender: String) {
		this(name, age, faceValue)//辅助构造器第一行必须先调用主构造器
		this.gender = gender
	}
	
}

//StructDemo的伴生对象 静态类
object StructDemo {
	def main(args: Array[String]): Unit = {
		val s = new StructDemo("james", 30, 80)
		println(s.name)
		println(s.age)
		println(s.getFaceValue())
		println("--------------------")
		
		val s1 = new StructDemo("haden", 20, 60, "man")
		println(s1.name)
		println(s1.age)
		println(s1.getFaceValue())
		println(s1.gender)
		
		
		
	}
}
