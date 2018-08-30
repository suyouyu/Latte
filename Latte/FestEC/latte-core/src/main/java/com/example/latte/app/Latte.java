package com.example.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by moransu on 2018/8/29.
 * class前加final,谁都不允许继承
 * Latte对外工具类，所以都是些静态方法
 */

public final class Latte {

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }
}
