package com.example.moransu.festec;

import android.app.Application;

import com.example.latte.app.Latte;
import com.example.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by moransu on 2018/8/29.
 * "http://127.0.0.1/" 本地地址
 */

@SuppressWarnings("DefaultFileTemplate")
public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
