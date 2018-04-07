package com.lizejun.demo.lib.base.util;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class FragmentUtils {

    public static void addFragment(AppCompatActivity activity, Fragment fragment, @IdRes int containerId) {
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerId, fragment);
        transaction.commit();
    }
}
