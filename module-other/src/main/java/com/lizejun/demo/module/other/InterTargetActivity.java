package com.lizejun.demo.module.other;


import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lizejun.demo.lib.base.ConstantMap;
import com.lizejun.demo.lib.base.RouterMap;

@Route(path = RouterMap.INTER_TARGET_ACTIVITY, extras = ConstantMap.LOGIN_EXTRA)
public class InterTargetActivity extends AppCompatActivity {


}
