package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/21 10:07
	* @Description:
	*/

import com.sun.org.apache.xpath.internal.functions.FuncTrue

import scala.actors.{Actor, Future}
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Random

object ActorDemo1 extends Actor{
	
	override def act(): Unit = {
		for (i <- 1 to 20) {
			println("actor1: " + i)
			Thread.sleep(1000)
		}
	}
	
}

object ActorDemo2 extends Actor{
	
	override def act(): Unit = {
		for (i <- 1 to 20) {
			println("actor2: " + i)
			Thread.sleep(1000)
		}
	}
	
}

class ActorDemo3 extends Actor{
	
	override def act(): Unit = {
		while (true) {
			// 偏函数
			receive {
				case "start" => println("starting...")
				case AsynMsg(id, msg) => {
					println(s"id: $id, AsynMsg: $msg")
					Thread.sleep(2000)
					sender ! ReplyMsg(new Random().nextInt(20), "success")
				}
				case SyncMsg(id, msg) => {
					println(s"id: $id, SyncMsg: $msg")
					Thread.sleep(2000)
					sender ! ReplyMsg(new Random().nextInt(20), "success")
				}
			}
		}
		for (i <- 1 to 20) {
			println("actor2: " + i)
			Thread.sleep(1000)
		}
	}
	
}

case class AsynMsg(id: Int, msg: String)
case class SyncMsg(id: Int, msg: String)
case class ReplyMsg(id: Int, msg: String)

object ActorTest {
	def main(args: Array[String]): Unit = {
		//ActorDemo1.start()
		//ActorDemo2.start()
		
		val demo3 = new ActorDemo3
		demo3.start()
		//异步调用消息 没有返回值
		demo3 ! AsynMsg(1, "Hello world actor!")
		println("没有返回值的异步消息发送完成")
		//同步发送消息，线程等待返回值
		val content: Any = demo3 !? SyncMsg(2, "Hi - kobe")
		println("有返回值的同步消息发送完成")
		println(content)
		//异步发送消息，有返回值 ，返回类型是Future[Any]
		val reply: Future[Any] = demo3 !! AsynMsg(3, "Hello idea")
		Thread.sleep(3000)
		if (reply.isSet) {
		  val value = reply.apply()
			println(value)
		} else {
			println("None")
		}
		
		
	}
}

class ActorWordCountTask extends Actor {
	override def act(): Unit = {
		while (true) {
			
			receive ({
				case SmTask(file) => {
					val lines: List[String] = Source.fromFile(file).getLines().toList
					val words: List[String] = lines.flatMap(_.split(""))
					val res =	words.map((_, 1)).groupBy(_._1).mapValues(_.size)
					//异步发送结果数据，没有返回值
					sender ! res
				}
			})
			
		}
	}
}

case class SmTask(file: String)

object ActorWordCount {
	
	def main(args: Array[String]): Unit = {
	  val files: Array[String] = Array("c://testfile/a.txt", "c://testfile/b.txt", "c://testfile/c.txt")
		// 存放接收到的每个文件的结果数据
		var replyList = new ListBuffer[Future[Any]]
		// 存放Future里有值 的数据
		val res = new ListBuffer[Map[String, Int]]
		
		for (file <- files) {
			val task = new ActorWordCountTask
			task.start()
			// 异步发送消息有返回值
			val reply: Future[Any] = task !! SmTask(file)
			// 把每个文件的数据存储到listbuffer里面
			replyList += reply
		}
		while (replyList.size > 0) {
			// 过虑每个Future对象，如果None类型的，就过虑掉
		  val dones =	replyList.filter(_.isSet)
			for (done <- dones) {
			  res += done.apply().asInstanceOf[Map[String, Int]]
				replyList -= done
			}
		}
    
		//得到全局聚合的数据
		println(res.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_ + _._2)))
		
		
	}
	
	
}
