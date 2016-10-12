package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.view.View;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.food.Base;

/**
 * Created by Administrator on 2016/10/6.
 */
public class TwoFood3Make2 extends Base {
    @Override
    public int setView() {
        return R.layout.two_make8;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }
    public void twowanb(View view){
        Intent intent = new Intent(this,TwoFood3.class);
        startActivity(intent);
        finish();
    }
}
