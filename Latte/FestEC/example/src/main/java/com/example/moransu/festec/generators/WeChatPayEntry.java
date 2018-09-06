package com.example.moransu.festec.generators;


import com.example.latte.wechat.templates.WXPayEntryTemplate;
import com.example.latte_annotations.PayEntryGenerator;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.example.moransu.festec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
