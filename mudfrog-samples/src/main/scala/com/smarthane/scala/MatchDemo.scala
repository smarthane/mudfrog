package com.smarthane.scala

import scala.util.Random

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/19 9:50
	* @Description:
	*/
class MatchDemo {
	
}

object MatchDemo {
	
	def main(args: Array[String]): Unit = {
		// 匹配字符串
		val arr1 = Array("abc", "lyh", "world", "hello")
		val name = arr1(Random.nextInt(arr1.length))
		println(name)
		name match {
			case "abc" => println("abc")
			case "lyh" => println("lyh")
			case "world" => println("world")
			case "hello" => println("hello")
			case _ => println("Nothing")
		}
		println("-------------------------")
		// 匹配类型
		val arr2 = Array("abcde", 100, 3.14, true, new MatchTest)
		
		val elem1 = arr2(Random.nextInt(arr2.length))
		elem1 match {
			case str: String => println(s"match String: $str")
			case int: Int => println(s"match int: $int")
			case bool: Boolean => println(s"match boolean: $bool")
			case matchTest: MatchTest => println(s"match matchTest: $matchTest")
			case _:Any => println("not matched")
		}
		println("-------------------------")
		// 匹配数组 元组 集合
		var arr3 = Array(3,2,5,7)
		arr3 match {
			case Array(3, a, b, c) => println(s"case: $a, $b, $c")
			case Array(_, x, y) => println(s"case: $x, $y")
			case _:Any => println("not matched")
		}
		// 匹配元组
		var tup1 = (6, 3, 4)
		tup1 match {
			case (2, a, b) => println(s"case: $a, $b")
			case (_, x, y) => println(s"case: $x, $y")
			case _:Any => println("not matched")
		}
		// 匹配集合        Nil代表一个空的集合
		var list1 = List(0, 1, 2, 3)
		list1 match {
			case 0 :: Nil => println(s"case1: 0")
			case a :: b :: c :: d :: Nil => println(s"case2: $a, $b, $c, $d")
			case 0 :: a => println(s"case3：$a")
			case _:Any => println("not matched")
		}
		println("-------------------------")
		// 匹配样例类
		
		val arr5 = Array(CheckTimeOutTask, SubmitTask("1000", "task-00001"), HeartBeat(1000))
	  val element2 = arr5(Random.nextInt(arr5.length))
		element2 match {
			case CheckTimeOutTask => println("case: CheckTimeOutTask")
			case SubmitTask(port, task) => println("case: SubmitTask")
			case HeartBeat(time) => println("case: HeartBeat")
			case _:Any => println("not matched")
		}
		
		println("-------------------------")
		// 匹配 偏函数
		println(m1("one"))
		println(m2("two"))
		
		
	}
	
	
	//PartialFunction[String, Int] 第一个为入参类型，第二个为返回值 类型,PartialFunction偏函数 常用作模式匹配
	def m1: PartialFunction[String, Int] = {
		case "one" => {
			println("case 1")
			1
		}
		case "two" => {
			println("case 2")
			2
		}
			
	}
	
	def m2(num: String): Int = num match {
		case "one" => 1
		case "two" => 2
		case _ => 0
	}
	
}

class MatchTest {
}

case class HeartBeat(time: Long)
case class SubmitTask(id: String, taskName: String)
case object CheckTimeOutTask


