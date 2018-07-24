package com.smarthane.spark.scalalearn.s01

import scala.reflect.internal.util.StringOps

import scala.math._

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/26 16:44
	* @Description:
	*/
object Test {
	
	
	
	
	def abs(x: Double) = if (x >= 0) x else -x
	
	def fac(n: Int) = {
		var r = 1
		for (i <- 1 to n) r = r * i
		r
	}
	
	def fac2(n: Int): Int = if (n <= 0) 1 else n * fac2(n - 1)
	
	
	def main(args: Array[String]): Unit = {
		
		val distance = {
			val dx = 9
			val dy = 8
			sqrt(dx * dx + dy * dy)
		}
 
		val abs1 = abs(-9)
		val fac1 = fac2(5)
		
		println(s"Hello world $distance --- $abs1 --- $fac1")
	}
	
}
