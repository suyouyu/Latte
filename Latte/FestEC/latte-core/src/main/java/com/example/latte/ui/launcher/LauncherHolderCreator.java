package com.example.latte.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by moransu on 2018/9/4.
 */

public  class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder>{

    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
