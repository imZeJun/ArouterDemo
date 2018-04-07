package com.lizejun.demo.lib.base.service;


import com.alibaba.android.arouter.facade.template.IProvider;

public interface IStoreModuleService extends IProvider {

    /**
     * 获取是否登录的状态。
     * @return 是否登录。
     */
    boolean isLogin();

    /**
     * 设置是否登录。
     * @param login 是否登录。
     */
    void setLogin(boolean login);
}
