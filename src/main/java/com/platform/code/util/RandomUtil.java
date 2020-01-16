package com.platform.code.util;

import java.util.UUID;

public class RandomUtil {

    public synchronized static String getUUID() {
        int machineId = 1;
        String hashCodeV = UUID.randomUUID().toString().replaceAll("-", "");
        return machineId + hashCodeV;
    }

    public static String getSet(Class<?> clazz){
        System.out.println(clazz);
        return "";
    }
}
