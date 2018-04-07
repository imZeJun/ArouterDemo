package com.lizejun.demo.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.demo.lizejun.module.home.R;
import com.lizejun.demo.lib.base.ConstantMap;
import com.lizejun.demo.lib.base.RouterMap;
import com.lizejun.demo.lib.base.util.Utils;

public class ResultClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_client);
        Button button = (Button) findViewById(R.id.bt_result_client);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouterMap.RESULT_SERVER_ACTIVITY).navigation(ResultClientActivity.this, ConstantMap.FOR_RESULT_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ConstantMap.FOR_RESULT_CODE:
                Utils.toast(ResultClientActivity.this, "receive=" + data.getStringExtra(ConstantMap.FOR_RESULT_KEY));
                break;
            default:
                break;
        }
    }
}
