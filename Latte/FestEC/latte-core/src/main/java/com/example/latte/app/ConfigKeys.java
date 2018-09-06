package com.example.latte.app;

import android.app.Application;

/**
 * Created by moransu on 2018/8/29.
 * 创建一个枚举类
 * 枚举类在整个应用程序里面它是唯一的单例并且只能被初始化一次,
 * 也就是说我们要进行一些多线程操作的时候，完全可以用枚举类来进行一个安全的惰性单例的初始化
 * 也就是通俗说线程安全的懒汉模式
 */

public enum ConfigKeys {
    /**
     *  配置网络请求的一些域名
     */
    API_HOST,
    /**
     *  全局的上下文
     */
    APPLICATION_CONTEXT,
    /**
     *  控制我的初始化或者我的配置完成了没有
     */
    CONFIG_READY,
    /**
     *  存出一些我们自己的初始化项目
     */
    ICON,
    LOADER_DELAYED,
    INTERCEPTOR
}
