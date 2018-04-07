package com.lizejun.demo.module.other;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lizejun.demo.lib.base.RouterMap;
import com.lizejun.demo.lib.base.util.Utils;

@Route(path = RouterMap.NO_RESULT_ACTIVITY)
public class NoResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.toast(this, "NoResultActivity onCreate");
    }
}
