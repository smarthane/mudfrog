package com.smarthane.mudfrog.sapmles.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.smarthane.mudfrog.sapmles.mqtt.utils.PublishClient;

import java.net.URISyntaxException;

public class PublishTest {
    public static void main(String[] args) throws URISyntaxException {


        PublishClient bb =  new PublishClient("tcp://192.168.100.196:1883", "iot/update/dev_id/+/app_id/+/forcedType/+", "bbaa002", "admin", "admin");
        JSONObject obj = new JSONObject();
        obj.put("deviceId", 5);
        obj.put("appid", 5);
        bb.run();
        bb.PublishMessage(obj.toJSONString());




//        PublishClient aa =  new PublishClient("tcp://192.168.100.196:1883", "$SYS/brokers/disconnected/clients/aa", "001", "admin", "admin");
//        JSONObject obj = new JSONObject();
//        obj.put("deviceId", 5);
//        obj.put("appid", 5);
//        aa.run();
//        int i = 0;
//        aa.PublishMessage(obj.toJSONString());
//        while (true){
//            aa.PublishMessage(obj.toJSONString());
//            SleepUtils.second(1);
//            i++;
//            System.out.println(i);
//        }
        //aa.disconnect();
    }
}
