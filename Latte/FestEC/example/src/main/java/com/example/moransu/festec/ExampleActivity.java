package com.example.moransu.festec;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.delegates.LatteDelegate;

/**
 * Created by moransu on 2018/8/30.
 */

public class ExampleActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
