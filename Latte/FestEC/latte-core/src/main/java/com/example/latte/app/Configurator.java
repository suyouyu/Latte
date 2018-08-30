package com.example.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * Created by moransu on 2018/8/29.
 * 配置文件
 * 配置文件的存储以及获取
 * java代码规范，不管是java还是android开发static final 类在声明和初始化的时候，名字要大写并且用下划线分隔
 *
 * 线程安全的懒汉模式:1-静态类部类,2-然后get它
 *
 */


public class Configurator {

    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    //然后get它
    @SuppressWarnings("WeakerAccess")
    public static Configurator getInstance(){
    return Holder.INSTANCE;
    }

    final WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    //静态类部类
    private static class Holder{
        private static final  Configurator INSTANCE = new Configurator();
    }

    public final void  configure(){
        //字体图标是通用的，所以在configure里面就把它加载好
        initIcons();
        //告诉配置文件,配置已经完成
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void initIcons(){
        if (ICONS.size()>0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1;i < ICONS.size();i++){
                initializer.with(ICONS.get(i));
            }
        }
    }

    public  final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }

    /**
     *  检查方法
     */
    private void checkConfiguration(){
        final  boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     *  检查方法
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
