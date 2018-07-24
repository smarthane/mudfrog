package com.smarthane.mudfrog.sapmles.mqtt.utils;


import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

import java.net.URISyntaxException;

public class Initialization {
    private final static boolean CLEAN_START = false;
    private final static short KEEP_ALIVE = 30;
    public final  static long RECONNECTION_ATTEMPT_MAX=-1;
    public final  static long RECONNECTION_DELAY=-1;
    public final static int SEND_BUFFER_SIZE=2*1024*1024;

    public  static  CallbackConnection GetCallbackConnection(String mqttBrokerUrl, String clientId, String userName, String passWord) throws URISyntaxException {
        MQTT mqtt = new MQTT();
        mqtt.setHost(mqttBrokerUrl);
        mqtt.setClientId(clientId);
        mqtt.setCleanSession(CLEAN_START);
        mqtt.setKeepAlive(KEEP_ALIVE);
        mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
        mqtt.setReconnectDelay(RECONNECTION_DELAY);
        mqtt.setUserName(userName);
        mqtt.setPassword(passWord);
        mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
        mqtt.setVersion("3.1.1");
        return mqtt.callbackConnection();
    }
}
