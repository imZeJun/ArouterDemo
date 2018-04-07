package com.lizejun.demo.module.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.demo.lizejun.module.other.R;
import com.lizejun.demo.lib.base.ConstantMap;
import com.lizejun.demo.lib.base.RouterMap;

import org.simple.eventbus.EventBus;

@Route(path = RouterMap.EVENT_BUS_ACTIVITY)
public class EventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        final int revValue = getIntent().getIntExtra(ConstantMap.EVENT_BUS_DATA, 0);
        Button button = (Button) findViewById(R.id.bt_event_bus);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("通过 EventBus 返回数据=" + revValue, ConstantMap.EVENT_BUS_KEY);
                finish();
            }
        });
    }
}
