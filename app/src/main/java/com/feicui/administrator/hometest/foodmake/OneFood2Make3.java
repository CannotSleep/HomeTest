package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.view.View;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.food.Base;

/**
 * Created by Administrator on 2016/10/6.
 */
public class OneFood2Make3 extends Base {
    @Override
    public int setView() {
        return R.layout.one_make6;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }
    public void jumponezhangac(View view){
        Intent intent = new Intent(this,OneFood2.class);
        startActivity(intent);
        finish();
    }
}
