package com.smarthane.mudfrog.sapmles.mqtt.utils;

import java.net.URISyntaxException;
import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.QoS;



public class PublishClient {
	private String MqttBrokerUrl;
	private String topic;
	private String ClientId;
	private String UserName;
	private String PassWord;
	private CallbackConnection callbackConnection = null;
	public final static int SEND_BUFFER_SIZE=2*1024*1024;//发送最大缓冲为2M
	private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s




	public PublishClient(String mqttBrokerUrl, String topic, String clientId, String userName, String passWord) {
        this.MqttBrokerUrl=mqttBrokerUrl;
        this.topic=topic;
        this.ClientId=clientId;
        this.UserName=userName;
        this.PassWord=passWord;
    }

	public PublishClient(String mqttBrokerUrl, String clientId, String userName, String passWord) {
		this.MqttBrokerUrl=mqttBrokerUrl;
		this.ClientId=clientId;
		this.UserName=userName;
		this.PassWord=passWord;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * 初始化发布消息客户端
	 * @return
	 */
	public void run() throws URISyntaxException {

        callbackConnection=Initialization.GetCallbackConnection(MqttBrokerUrl,ClientId,UserName,PassWord);
        callbackConnection.connect(new Callback() {
			public void onFailure(Throwable arg0) {
                System.out.println("connect failure");
			}

			public void onSuccess(Object arg0) {
                System.out.println("connect success");
			}
		});
	}




	public void  PublishMessage(String msgContent){
		callbackConnection.publish(topic, msgContent.getBytes(), QoS.AT_LEAST_ONCE, true, new Callback<Void>(){
					public void onSuccess(Void aVoid) {
                        System.out.println("send message ok");
					}

					public void onFailure(Throwable throwable){
                        System.out.println("send message failure");
					}
				}
		);
	}


	public void disconnect(){
		callbackConnection.disconnect(null);
	}
}
