package com.smarthane.mudfrog.sapmles.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.nustaq.serialization.FSTConfiguration;

import java.io.*;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/7/20 10:40
 * @Description:
 */
public class SerializerUtil {

    private static FSTConfiguration fstConfiguration = FSTConfiguration.createStructConfiguration();
    private static Kryo kryo = new Kryo();

    public static byte[] fstSerialize(Object obj) {
        return fstConfiguration.asByteArray(obj);
    }

    public static Object fstUnserialize(byte[] sec) {
        return fstConfiguration.asObject(sec);
    }

    public static byte[] kryoSerizlize(Object obj) {
        try {
            Kryo kryo = new Kryo();
            byte[] buffer = new byte[2048];
            Output output = new Output(buffer);
            kryo.writeClassAndObject(output, obj);
            return output.toBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object kryoUnSerizlize(byte[] src) {
        try {
            Input input = new Input(src);
            return kryo.readClassAndObject(input);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return kryo;
    }

    // jdk原生序列换方案
    public static byte[] jdkserialize(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object jdkdeserialize(byte[] bits) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bits);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
