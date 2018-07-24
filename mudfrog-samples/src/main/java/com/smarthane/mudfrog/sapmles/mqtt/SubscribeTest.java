package com.smarthane.mudfrog.sapmles.mqtt;


import com.smarthane.mudfrog.sapmles.mqtt.utils.SleepUtils;
import com.smarthane.mudfrog.sapmles.mqtt.utils.SubscribeClient;

import java.net.URISyntaxException;

public class SubscribeTest {

    public static void main(String[] args) throws URISyntaxException {
        SubscribeClient bb =  new SubscribeClient("tcp://192.168.100.196:1883", new String[]{"iot/update/dev_id/+/app_id/+/forcedType/+","iot/update/dev_type/+/app_id/+/version/#"}, "bbaa002", "admin", "admin");
        bb.run(new MyLs());
        while (true){
            SleepUtils.second(1);
        }
    }
}
