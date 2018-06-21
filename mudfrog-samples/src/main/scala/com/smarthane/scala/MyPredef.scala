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
	
	implicit val selectGirl2 = (g: Girl2) => new Ordered[Girl2] {
		override def compare(that: Girl2): Int = {
			if (g.faceValue == that.faceValue) {
				that.age - g.age
			} else {
				g.faceValue - that.faceValue
			}
		}
	}
	
	implicit object OrderingGirl2 extends Ordering[Girl2] {
		override def compare(x: Girl2, y: Girl2): Int = {
			if (x.faceValue == y.faceValue) {
				y.age - x.age
			} else {
				x.faceValue - y.faceValue
			}
		}
	}
	
}
