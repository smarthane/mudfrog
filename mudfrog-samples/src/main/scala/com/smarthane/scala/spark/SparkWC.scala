package com.smarthane.scala.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/25 17:04
	* @Description: spark word count
	*/
object SparkWC {
	
	def main(args: Array[String]): Unit = {
		
		// 配置信息类
	  val conf: SparkConf = new SparkConf()
			.setAppName("SparkWC") //应用程序名称
			.setMaster("local[*]") //启动多少个线程 本机模拟测试
		// 上下文对象
	  val sc: SparkContext = new SparkContext(conf)
		// 读取数据
		val lines = sc.textFile(args(0))
		// 处理数据
		val words: RDD[String] = lines.flatMap(_.split(" "))
	  val paired: RDD[(String, Int)] = words.map((_, 1))
		val reduced: RDD[(String, Int)] = paired.reduceByKey(_+_)
		val res: RDD[(String, Int)] = reduced.sortBy(_._2, false)
		// 保存数据
		//res.saveAsTextFile(args(1))
		println(res.collect().toBuffer)
		
		// 结束任务
		sc.stop()
		
	}
	
}
