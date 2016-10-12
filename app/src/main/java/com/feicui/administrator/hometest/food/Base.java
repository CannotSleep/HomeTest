package com.feicui.administrator.hometest.food;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/10/3.
 */
public abstract class Base extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setView());
        initView();
        setListener();
    }

    public abstract int setView();

    public abstract void initView();

    public abstract void setListener();
}
