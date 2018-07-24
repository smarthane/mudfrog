package com.smarthane.mudfrog.sapmles.mqtt.utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
	public static final void second (long seconds){
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static final void millisecond (long millisecond){
		try {
			TimeUnit.MILLISECONDS.sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
