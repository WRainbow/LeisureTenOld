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

    public static final String BASERURL_JUHU = "http://v.juhe.cn/";
    public static final String ADDRESS_PICJUMBO = "https://picjumbo.com/";
    public static final String SHOWAPI_APPID = "34505";
    public static final String SHOWAPI_SIGN = "5f5174a8dada496e8b10ad2aabca5b15";
    public static final String BASEURL_PICCLASSIFICATIONURL = "http://route.showapi.com/";
}
