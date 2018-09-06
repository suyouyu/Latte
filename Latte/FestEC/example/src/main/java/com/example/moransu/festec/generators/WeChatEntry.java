package com.example.moransu.festec.generators;


import com.example.latte.wechat.templates.WXEntryTemplate;
import com.example.latte_annotations.EntryGenerator;

/**
 * Created by 傅令杰 on 2017/4/22
 */

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.example.moransu.festec",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
