package com.smarthane.mudfrog.sapmles.mqtt.utils;

import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.CallbackConnection;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;

import java.util.ArrayList;
import java.util.List;


public class CallbackHandle implements Callback {
    private CallbackConnection cbC = null;
    private String[] topics;
    private String status="";
    CallbackHandle(CallbackConnection cc, String[] topics){
        this.cbC = cc;
        this.topics = topics;
    }
    // 连接成功
    public void onSuccess(Object o) {
        //订阅主题
        List<Topic> ltopics = new ArrayList<Topic>();
        for (String topic:topics){
            ltopics.add(new Topic(topic, QoS.AT_LEAST_ONCE));
        }
        Topic[] array =new Topic[ltopics.size()];
        cbC.subscribe(ltopics.toArray(array), new Callback<byte[]>() {
            //订阅主题成功
            public void onSuccess(byte[] bytes) {
                status="subscribe onSuccess";
            }

            //订阅主题失败
            public void onFailure(Throwable throwable) {
                status="subscribe onFailure";
                cbC.disconnect(null);
            }
        });
    }

    //连接失败
    public void onFailure(Throwable throwable) {
        status="connect Failure";
        cbC.disconnect(null);
    }

    public String getStatus() {
        return status;
    }
}
