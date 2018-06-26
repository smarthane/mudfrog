//package com.smarthane.scala.akka
//
///**
//	* Created with by smarthane-cloud-microservice.
//	*
//	* @author: smarthane
//	* @Date: 2018/6/22 18:01
//	* @Description:
//	*/
//
//
//import java.util.UUID
//
//import akka.actor.Actor.Receive
//import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
//import com.typesafe.config.ConfigFactory
//
//import scala.collection.mutable
//import scala.concurrent.duration._
//
//
//class Worker(val host: String, val port: Int, val masterHost: String,
//						 val masterPort: Int, val memory: Int, val cores: Int) extends Actor{
//
//	val worker_id = UUID.randomUUID().toString
//	var masterUrl: String = _
//	val HEARTBEAT_INTERVAL = 10000
//	var master : ActorSelection = _
//
//	override def preStart(): Unit = {
//		master = context.actorSelection(s"akka.tcp://${Master.MASTER_SYSTEM}" +
//		s"@$masterHost:$masterPort/user/${Master.MASTER_ACTOR}")
//		master ! RegisterWorker(worker_id, host, port, memory, cores)
//	}
//
//	override def receive: Receive = {
//
//	}
//}
