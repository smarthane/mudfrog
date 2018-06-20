package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/20 10:37
	* @Description:柯里化
	*/

object Context {
	implicit val a = "java"
}

object CurryingDemo {
	
	
	def m1(str: String)(implicit name: String = "scala") = {
		println(str + name)
	}
	
	def main(args: Array[String]): Unit = {
		 m1("Hi ~")
		
		import Context.a
		 m1("Hi ~")
	}
	
}


