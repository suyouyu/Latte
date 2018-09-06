package com.example.moransu.festec.generators;


import com.example.latte.wechat.templates.AppRegisterTemplate;
import com.example.latte_annotations.AppRegisterGenerator;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.example.moransu.festec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
