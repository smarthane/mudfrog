package com.smarthane.spark.scalalearn.s01

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/27 17:45
	* @Description:
	*/

import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object SparkTest {
	val conf: SparkConf = new SparkConf().setAppName("xtq").setMaster("local[2]")
	val sc: SparkContext = new SparkContext(conf)
	
	/**
		* 创建数据的方式--从内存里构造数据(基础)
		*/
	def createDataMethod(): Unit = {
		/* 使用makeRDD创建RDD */
		/* List */
		val rdd01 = sc.makeRDD(List(1, 2, 3, 4, 5, 6))
		val r01 = rdd01.map { x => x * x }
		println("===================createDataMethod:makeRDD:List=====================")
		println(r01.collect().mkString(","))
		println("===================createDataMethod:makeRDD:List=====================")
		/* Array */
		val rdd02 = sc.makeRDD(Array(1, 2, 3, 4, 5, 6))
		val r02 = rdd02.filter { x => x < 5 }
		println("===================createDataMethod:makeRDD:Array=====================")
		println(r02.collect().mkString(","))
		println("===================createDataMethod:makeRDD:Array=====================")
		
		/* 使用parallelize创建RDD */
		/* List */
		val rdd03 = sc.parallelize(List(1, 2, 3, 4, 5, 6), 1)
		val r03 = rdd03.map { x => x + 1 }
		println("===================createDataMethod:parallelize:List=====================")
		println(r03.collect().mkString(","))
		println("===================createDataMethod:parallelize:List=====================")
		/* Array */
		val rdd04 = sc.parallelize(List(1, 2, 3, 4, 5, 6), 1)
		val r04 = rdd04.filter { x => x > 3 }
		println("===================createDataMethod:parallelize:Array=====================")
		println(r04.collect().mkString(","))
		println("===================createDataMethod:parallelize:Array=====================")
	}
	
	/**
		* 创建Pair Map
		*/
	def createPairRDD(): Unit = {
		val rdd: RDD[(String, Int)] = sc.makeRDD(List(("key01", 1), ("key02", 2), ("key03", 3)))
		val r: RDD[String] = rdd.keys
		println("===========================createPairRDD=================================")
		println(r.collect().mkString(","))
		println("===========================createPairRDD=================================")
	}
	
	/**
		* 通过文件创建RDD
		* 文件数据：
		* key01,1,2.3
		* key02,5,3.7
		* key03,23,4.8
		* key04,12,3.9
		* key05,7,1.3
		*/
	def createDataFromFile(path: String): Unit = {
		val rdd: RDD[String] = sc.textFile(path, 1)
		val r: RDD[String] = rdd.flatMap { x => x.split(",") }
		println("=========================createDataFromFile==================================")
		println(r.collect().mkString(","))
		println("=========================createDataFromFile==================================")
	}
	
	/**
		* 基本的RDD操作
		*/
	def basicTransformRDD(path: String): Unit = {
		val rddInt: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 2, 5, 1))
		val rddStr: RDD[String] = sc.parallelize(Array("a", "b", "c", "d", "b", "a"), 1)
		val rddFile: RDD[String] = sc.textFile(path, 1)
		
		val rdd01: RDD[Int] = sc.makeRDD(List(1, 3, 5, 3))
		val rdd02: RDD[Int] = sc.makeRDD(List(2, 4, 5, 1))
		
		/* map操作 */
		println("======map操作======")
		println(rddInt.map(x => x + 1).collect().mkString(","))
		println("======map操作======")
		/* filter操作 */
		println("======filter操作======")
		println(rddInt.filter(x => x > 4).collect().mkString(","))
		println("======filter操作======")
		/* flatMap操作 */
		println("======flatMap操作======")
		println(rddFile.flatMap { x => x.split(",") }.first())
		println("======flatMap操作======")
		/* distinct去重操作 */
		println("======distinct去重======")
		println(rddInt.distinct().collect().mkString(","))
		println(rddStr.distinct().collect().mkString(","))
		println("======distinct去重======")
		/* union操作 */
		println("======union操作======")
		println(rdd01.union(rdd02).collect().mkString(","))
		println("======union操作======")
		/* intersection操作 */
		println("======intersection操作======")
		println(rdd01.intersection(rdd02).collect().mkString(","))
		println("======intersection操作======")
		/* subtract操作 */
		println("======subtract操作======")
		println(rdd01.subtract(rdd02).collect().mkString(","))
		println("======subtract操作======")
		/* cartesian操作 */
		println("======cartesian操作======")
		println(rdd01.cartesian(rdd02).collect().mkString(","))
		println("======cartesian操作======")
	}
	
	/**
		* 基本的RDD行动操作
		*/
	def basicActionRDD(): Unit = {
		val rddInt: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 2, 5, 1))
		val rddStr: RDD[String] = sc.parallelize(Array("a", "b", "c", "d", "b", "a"), 1)
		
		/* count操作 */
		println("======count操作======")
		println(rddInt.count())
		println("======count操作======")
		/* countByValue操作 */
		println("======countByValue操作======")
		println(rddInt.countByValue())
		println("======countByValue操作======")
		/* reduce操作 */
		println("======countByValue操作======")
		println(rddInt.reduce((x, y) => x + y))
		println("======countByValue操作======")
		/* fold操作 */
		println("======fold操作======")
		println(rddInt.fold(0)((x, y) => x + y))
		println("======fold操作======")
		/* aggregate操作 */
		println("======aggregate操作======")
		val res: (Int, Int) = rddInt.aggregate((0, 0))((x, y) => (x._1 + x._2, y), (x, y) => (x._1 + x._2, y._1 + y._2))
		println(res._1 + "," + res._2)
		println("======aggregate操作======")
		/* foeach操作 */
		println("======foeach操作======")
		println(rddStr.foreach { x => println(x) })
		println("======foeach操作======")
	}
	
	def main(args: Array[String]): Unit = {
		println(System.getenv("HADOOP_HOME"))
		createDataMethod()
		createPairRDD()
		//createDataFromFile("file:///D:/sparkdata.txt")
		//basicTransformRDD("file:///D:/sparkdata.txt")
		//basicActionRDD()
		/*打印结果*/
		/*D://hadoop
===================createDataMethod:makeRDD:List=====================
1,4,9,16,25,36
===================createDataMethod:makeRDD:List=====================
===================createDataMethod:makeRDD:Array=====================
1,2,3,4
===================createDataMethod:makeRDD:Array=====================
===================createDataMethod:parallelize:List=====================
2,3,4,5,6,7
===================createDataMethod:parallelize:List=====================
===================createDataMethod:parallelize:Array=====================
4,5,6
===================createDataMethod:parallelize:Array=====================
===========================createPairRDD=================================
key01,key02,key03
===========================createPairRDD=================================
key01,1,2.3,key02,5,3.7,key03,23,4.8,key04,12,3.9,key05,7,1.3
=========================createDataFromFile==================================
2,3,4,5,6,7,3,6,2
======map操作======
======filter操作======
5,6,5
======filter操作======
======flatMap操作======
key01
======flatMap操作======
======distinct去重======
4,6,2,1,3,5
======distinct去重======
======union操作======
1,3,5,3,2,4,5,1
======union操作======
======intersection操作======
1,5
======intersection操作======
======subtract操作======
3,3
======subtract操作======
======cartesian操作======
(1,2),(1,4),(3,2),(3,4),(1,5),(1,1),(3,5),(3,1),(5,2),(5,4),(3,2),(3,4),(5,5),(5,1),(3,5),(3,1)
======cartesian操作======
======count操作======
9
======count操作======
======countByValue操作======
Map(5 -> 2, 1 -> 2, 6 -> 1, 2 -> 2, 3 -> 1, 4 -> 1)
======countByValue操作======
======countByValue操作======
29
======countByValue操作======
======fold操作======
29
======fold操作======
======aggregate操作======
19,10
======aggregate操作======
======foeach操作======
a
b
c
d
b
a
======foeach操作======*/
	}
}
