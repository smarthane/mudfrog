package com.smarthane.scala

import scala.io.Source

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/20 11:00
	* @Description:
	*/
class RichFile(val path: String) {
	
	def read(): String = {
		Source.fromFile(path).mkString
	}
	
}


object RichFile {
	
	
	def main(args: Array[String]): Unit = {
		// 这个过程是显式的实现了read方法
		val file = "D:\\视频教程\\千锋大数据教程：Spark基础及源码分析\\learn-spark-mark-04.txt"
		val str = new RichFile(file).read()
		println(str)
		println("---------------------------------------------")
		// 隐式转换函数
		import com.smarthane.scala.MyPredef.fileToRichFile
		val context = file.read()
		println(context)
		
		
		
	}
	
}
