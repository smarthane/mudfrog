package com.smarthane.mudfrog.sapmles.mqtt.utils;

import java.net.URISyntaxException;
import org.fusesource.mqtt.client.*;


public class SubscribeClient {
	private String MqttBrokerUrl;
	private String[] topic;
	private String ClientId;
	private String UserName;
	private String PassWord;
    private CallbackConnection callbackConnection= null;


	public SubscribeClient(String mqttBrokerUrl, String[] topic, String clientId, String userName, String passWord) {
		this.MqttBrokerUrl=mqttBrokerUrl;
		this.topic=topic;
		this.ClientId=clientId;
		this.UserName=userName;
		this.PassWord=passWord;
	}
	
	public void run(ExtendedListener myListener) throws URISyntaxException {
        callbackConnection = Initialization.GetCallbackConnection(MqttBrokerUrl,ClientId,UserName,PassWord);
        callbackConnection.listener(myListener);
        CallbackHandle  callbackHandle =  new CallbackHandle(callbackConnection,topic);
        callbackConnection.connect(callbackHandle);
	}


    /**
     * 断开连接
     */
    public void disconnect(){
        callbackConnection.disconnect(null);
    }
}
