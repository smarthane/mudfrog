package com.smarthane.spark.scalalearn.s01

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/27 14:29
	* @Description: 在函数式编程语言中，函数是“头等公民”，它可以像任何其他数据类型一样被传递和操作
案例：首先定义一个方法，再定义一个函数，然后将函数传递到方法里面 
	*/
object MethodAndFunctionDemo {
	
	//定义一个方法
	//方法m2参数要求是一个函数，函数的参数必须是两个Int类型
	//返回值类型也是Int类型
	def m1(f:(Int,Int) => Int) : Int = {
		f(2,6)
	}
	
	//定义一个函数f1,参数是两个Int类型，返回值是一个Int类型
	val f1 = (x:Int,y:Int) => x + y
	//再定义一个函数f2
	val f2 = (m:Int,n:Int) => m * n
	
	
	
	
	def ttt(f:Int => Int):Unit = {
		val r = f(10)
		println(r)
	}
	
	val f0 = (x : Int) => x * x
	
	//定义了一个方法
	def m0(x:Int) : Int = {
		//传递进来的参数乘以10
		x * 10
	}
	
	//将方法转换成函数，利用了神奇的下滑线
	val f11 = m0 _
	
	
	
	
	//main方法
	def main(args: Array[String]): Unit = {
		//调用m1方法，并传入f1函数
		val r1 = m1(f1)
		
		println(r1)
		
		//调用m1方法，并传入f2函数
		val r2 = m1(f2)
		println(r2)
		
		println("---------------------")
		ttt(f0)
		
		//通过m0 _将方法转化成函数
		ttt(m0 _);
		
		//如果直接传递的是方法名称，scala相当于是把方法转成了函数
		ttt(m0)
		
		//通过x => m0(x)的方式将方法转化成函数,这个函数是一个匿名函数，等价：(x:Int) => m0(x)
		ttt(x => m0(x))
		
	}
	
}
