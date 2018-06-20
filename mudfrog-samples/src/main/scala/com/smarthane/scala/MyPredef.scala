package com.smarthane.scala

/**
	* Created with by smarthane-cloud-microservice.
	*
	* @author: smarthane
	* @Date: 2018/6/20 11:09
	* @Description:
	*/
object MyPredef {
	
	implicit def fileToRichFile(file: String) = new RichFile(file)
	
}
