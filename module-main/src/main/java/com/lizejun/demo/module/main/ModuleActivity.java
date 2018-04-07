package com.lizejun.demo.module.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.demo.lizejun.module.main.R;

public class ModuleActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);
    }
}
