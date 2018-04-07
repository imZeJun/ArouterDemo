package com.lizejun.demo.module.other;


import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lizejun.demo.lib.base.RouterMap;

@Route(path = RouterMap.INTER_TARGET_ACTIVITY, group = RouterMap.INTERCEPT_GROUP)
public class InterTargetActivity extends AppCompatActivity {


}
