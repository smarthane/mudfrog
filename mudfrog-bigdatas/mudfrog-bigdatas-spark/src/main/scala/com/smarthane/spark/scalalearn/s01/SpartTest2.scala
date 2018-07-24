package com.smarthane.spark.scalalearn.s01

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j.Logger
import org.apache.log4j.Level
/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/27 18:04
	* @Description:
	*/
object SpartTest2 {
	
	
	def main(args: Array[String]): Unit = {
		
		Logger.getLogger("org").setLevel(Level.OFF)
		Logger.getLogger("com").setLevel(Level.OFF)
		System.setProperty("spark.ui.showConsoleProgress", "false")
		Logger.getRootLogger().setLevel(Level.OFF)
		
		val conf: SparkConf = new SparkConf().setAppName("SpartTest2").setMaster("local[2]")
		val sc: SparkContext = new SparkContext(conf)
		val rdd01 = sc.makeRDD(List(1, 2, 3, 4, 5, 6))
		val r01 = rdd01.map { x => x * x }
		println(r01.collect().mkString(","))
		
	}
	
}
