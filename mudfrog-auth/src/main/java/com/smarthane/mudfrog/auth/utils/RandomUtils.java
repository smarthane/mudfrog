package com.smarthane.mudfrog.auth.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created with by smarthane-cloud-microservice.
 *
 * @author: smarthane
 * @Date: 2018/6/21 17:20
 * @Description: UUID工具类
 */
public class RandomUtils {

    private final static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    /**
     * 生成不带"-"号的UUID
     *
     * @return 生成的UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成带"-"号的小写UUID
     *
     * @return 带"-"号的UUID
     */
    public static String getUUIDWithHyphen() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成指定位数随机码(纯数字)
     *
     * @param length 长度
     * @return 随机码
     * @since 1.0.0
     */
    public static String getRandomInteger(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    /**
     * 生成指定位数随机码(数字和大小写字母)
     *
     * @param length 长度
     * @return 随机码
     * @since 1.0.0
     */
    public static String getRandomChar(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<length;i++){
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }

}
