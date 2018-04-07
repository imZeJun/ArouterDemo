package com.lizejun.demo.lib.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lizejun.demo.lib.base.util.Utils;

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRouter(this);
    }

    public static Context getInstance() {
        return instance;
    }

    private void initRouter(BaseApplication mApplication) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (Utils.isApkInDebug(instance)) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(mApplication);


    }
}
