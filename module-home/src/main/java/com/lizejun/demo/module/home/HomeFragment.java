package com.lizejun.demo.module.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.demo.lizejun.module.home.R;
import com.lizejun.demo.lib.base.ConstantMap;
import com.lizejun.demo.lib.base.RouterMap;
import com.lizejun.demo.lib.base.bean.SerialBean;
import com.lizejun.demo.lib.base.service.StoreModuleRouterService;
import com.lizejun.demo.lib.base.util.Utils;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

@Route(path = RouterMap.HOME_FRAGMENT)
public class HomeFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_home, container, false);
        Button noResultButton = (Button) view.findViewById(R.id.bt_no_result);
        noResultButton.setOnClickListener(new HomeClickListener());
        Button resultClientButton = (Button) view.findViewById(R.id.bt_result_client);
        resultClientButton.setOnClickListener(new HomeClickListener());
        Button eventBusButton = (Button) view.findViewById(R.id.bt_event_bus);
        eventBusButton.setOnClickListener(new HomeClickListener());
        Button interButton = (Button) view.findViewById(R.id.bt_intercept);
        interButton.setOnClickListener(new HomeClickListener());
        Button injectButton = (Button) view.findViewById(R.id.bt_inject);
        injectButton.setOnClickListener(new HomeClickListener());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private class HomeClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.bt_no_result) {
                ARouter.getInstance().build(RouterMap.NO_RESULT_ACTIVITY).navigation();
            } else if (id == R.id.bt_result_client) {
                getActivity().startActivity(new Intent(getActivity(), ResultClientActivity.class));
            } else if (id == R.id.bt_event_bus) {
                ARouter.getInstance().build(RouterMap.EVENT_BUS_ACTIVITY)
                        .withInt(ConstantMap.EVENT_BUS_DATA, 1000)
                        .navigation();
            } else if (id == R.id.bt_intercept) {
                ARouter.getInstance().build(RouterMap.INTER_TARGET_ACTIVITY)
                        .withBoolean(ConstantMap.IS_LOGIN, StoreModuleRouterService.isLogin())
                        .navigation();
            } else if (id == R.id.bt_inject) {
                SerialBean bean = new SerialBean();
                bean.setName("SerialBean");
                bean.setAge(18);
                ARouter.getInstance().build(RouterMap.INJECT_ACTIVITY)
                        .withInt(ConstantMap.INJECT_AGE, 18)
                        .withObject(ConstantMap.INJECT_OBJECT, bean)
                        .navigation();
            }
        }
    }

    @Subscriber(tag = ConstantMap.EVENT_BUS_KEY)
    public void onEvent(String s) {
        Utils.toast(getContext(), s);
    }
}
