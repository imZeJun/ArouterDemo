package com.lizejun.demo.module.other;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.demo.lizejun.module.other.R;
import com.lizejun.demo.lib.base.RouterMap;
import com.lizejun.demo.lib.base.service.StoreModuleRouterService;

@Route(path = RouterMap.INTER_MIDDLE_ACTIVITY)
public class InterMiddleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_middle);
        updateStatus();
        switchStatus();
    }

    private void updateStatus() {
        TextView tvStatus = (TextView) findViewById(R.id.tv_login_status);
        tvStatus.setText("登录状态=" + StoreModuleRouterService.isLogin());
    }

    private void switchStatus() {
        final Switch switchStatus = (Switch) findViewById(R.id.sw_login);
        switchStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                StoreModuleRouterService.setLogin(isChecked);
                updateStatus();
            }
        });
    }
}
