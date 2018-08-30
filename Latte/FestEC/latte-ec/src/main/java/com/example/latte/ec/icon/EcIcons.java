package com.example.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by moransu on 2018/8/29.
 */

public enum  EcIcons implements Icon{
    icon_scan('\ue619'),
    icon_ali_pay('\ue619');

    private char cjaracter;

    EcIcons(char cjaracter){
        this.cjaracter = cjaracter;
    }
    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return cjaracter;
    }
}
