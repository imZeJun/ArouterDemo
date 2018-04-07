package com.lizejun.demo.module.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.demo.lizejun.module.other.R;
import com.lizejun.demo.lib.base.ConstantMap;
import com.lizejun.demo.lib.base.RouterMap;

@Route(path = RouterMap.RESULT_SERVER_ACTIVITY)
public class ResultServerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_server);
        Button button = (Button) findViewById(R.id.bt_for_result);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ConstantMap.FOR_RESULT_KEY, "返回数据给 Client");
                setResult(ConstantMap.FOR_RESULT_CODE, intent);
                finish();
            }
        });
    }

}
