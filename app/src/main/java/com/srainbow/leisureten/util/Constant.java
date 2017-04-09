package com.srainbow.leisureten.util;

/**
 * Created by SRainbow on 2017/4/9.
 */

public class Constant {
    private volatile static Constant instance = null;

    private Constant(){}

    public static Constant getInstance(){
        if(instance == null){
            synchronized (Constant.class){
                if(instance == null){
                    instance = new Constant();
                }
            }
        }
        return instance;
    }

    public static final String Address_PICJUMBO = "https://picjumbo.com/";
}
