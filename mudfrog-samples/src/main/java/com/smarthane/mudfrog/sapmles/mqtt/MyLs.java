package com.smarthane.mudfrog.sapmles.mqtt;

import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Callback;
import org.fusesource.mqtt.client.ExtendedListener;

public class MyLs implements ExtendedListener {

    public void onPublish(UTF8Buffer topic, Buffer body, Callback<Callback<Void>> ack) {
        System.out.println(new String(body.toByteArray()));
        ack.onSuccess(new Callback(){
            public void onSuccess(Object value) {

            }

            public void onFailure(Throwable value) {

            }
        });
    }

    public void onConnected() {
        System.out.println("onConnected");
    }

    public void onDisconnected() {
        System.out.println("onDisconnected");
    }

    public void onFailure(Throwable value) {
        System.out.println("onFailure");
    }

    public void onPublish(UTF8Buffer topic, Buffer body, Runnable ack) {
    }
}
