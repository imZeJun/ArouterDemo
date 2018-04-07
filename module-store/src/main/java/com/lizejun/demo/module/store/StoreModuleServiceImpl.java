package com.lizejun.demo.module.store;


import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lizejun.demo.lib.base.RouterMap;
import com.lizejun.demo.lib.base.service.IStoreModuleService;

@Route(path = RouterMap.STORE_MODULE_SERVICE)
public class StoreModuleServiceImpl implements IStoreModuleService {

    private static final String FILE = "account";
    private static final String IS_LOGIN = "is_login";


    private Context mContext;

    @Override
    public void init(Context context) {
        mContext = context;
    }

    @Override
    public boolean isLogin() {
        return mContext.getSharedPreferences(FILE, Context.MODE_PRIVATE).getBoolean(IS_LOGIN, false);
    }

    @Override
    public void setLogin(boolean login) {
        mContext.getSharedPreferences(FILE, Context.MODE_PRIVATE).edit().putBoolean(IS_LOGIN, login).apply();
    }
}
