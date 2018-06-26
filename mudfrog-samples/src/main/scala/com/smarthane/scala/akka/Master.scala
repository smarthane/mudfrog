//package com.smarthane.scala.akka
//
///**
//	* Created with by smarthane-cloud-microservice.
//	*
//	* @author: smarthane
//	* @Date: 2018/6/22 17:36
//	* @Description:
//	*/
//
//import akka.actor.{Actor, ActorRef, ActorSystem, Props}
//import com.typesafe.config.ConfigFactory
//import scala.collection.mutable
//import scala.concurrent.duration._
//
//
//class Master(val masterHost: String, val masterPort: Int) extends Actor{
//
//	val idToWorker = new mutable.HashMap[String, WorkerInfo]()
//
//	val workers = new mutable.HashSet[WorkerInfo]()
//	val CHECK_INTERVAL = 15000
//
//	override def preStart(): Unit = {
//
//		import context.dispatcher
//		context.system.scheduler.schedule(0, CHECK_INTERVAL, self, CheckTimeOutWorker)
//
//
//	}
//
//	override def receive: Receive = {
//
//		case RegisterWorker(id, host, port, memory, cores) => {
//			  if (!idToWorker.contains(id)) {
//					val workerInfo = new WorkerInfo(id, host, port, memory, cores)
//					idToWorker += (id -> workerInfo)
//					workers += workerInfo
//					println("a worker registered")
//					sender ! RegisteredWorker(s"akka.tcp://${Master.MASTER_SYSTEM}" + s"@$masterHost:$masterPort/user/${Master.MASTER_ACTOR}")
//
//				}
//		}
//
//		case Heartbeat(workerId) => {
//			val workerInfo = idToWorker(workerId)
//			val current_time = System.currentTimeMillis()
//			workerInfo.lastHeartbearTime = current_time
//		}
//
//		case CheckTimeOutWorker => {
//			val currentTime = System.currentTimeMillis()
//			val toRemove: mutable.HashSet[WorkerInfo] = workers.filter(w => currentTime - w.lastHeartbearTime > CHECK_INTERVAL)
//			toRemove.foreach(deadWorker => {
//				idToWorker -= deadWorker.id
//				workers -= deadWorker
//			})
//			println("num of workers " + workers.size)
//
//		}
//	}
//
//	object Master {
//
//		val MASTER_SYSTEM = "MasterSystem"
//		val MASTER_ACTOR = "Master"
//
//		def main(args: Array[String]): Unit = {
//
//			val host = args(0)
//			val port = args(1).toInt
//			val configStr =
//				s"""
//					|akka.actor.provider = "akka.remote.RemoteActorRefProvider"
//					|akka.remote.netty.tcp.hostname = "$host"
//					|akka.remote.netty.tcp.port = "$port"
//					""".stripMargin
//			val config = ConfigFactory.parseString(configStr)
//			val actorSystem = ActorSystem(MASTER_SYSTEM, config)
//			actorSystem.actorOf(Props(new Master(host, port)), MASTER_ACTOR)
//			actorSystem.awaitTermination()
//
//
//
//
//
//
//
//		}
//
//
//	}
//
//}
