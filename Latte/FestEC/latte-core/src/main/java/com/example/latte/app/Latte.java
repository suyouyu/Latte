package com.example.latte.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created by moransu on 2018/8/29.
 * class前加final,谁都不允许继承
 * Latte对外工具类，所以都是些静态方法
 */

public final class Latte {

//    public static Configurator init(Context context){
//        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(),context.getApplicationContext());
//        return Configurator.getInstance();
//    }
//
//    public static HashMap<Object,Object> getConfigurations(){
//        return Configurator.getInstance().getLatteConfigs();
//    }
//
//    public static Configurator getConfigurator() {
//        return Configurator.getInstance();
//    }
//
//    public static <T> T getConfiguration(Object key) {
//        return getConfigurator().getConfiguration(key);
//    }
//
//    public static Context getApplication(){
//        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT.name());
//    }
public static Configurator init(Context context) {
    Configurator.getInstance()
            .getLatteConfigs()
            .put(ConfigKeys.APPLICATION_CONTEXT,
                    context.getApplicationContext());
    return Configurator.getInstance();
}

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return  Configurator.getInstance().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return Configurator.getInstance().getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }


}
