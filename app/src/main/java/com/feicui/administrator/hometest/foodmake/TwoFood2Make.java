package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.view.View;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.food.Base;

/**
 * Created by Administrator on 2016/10/6.
 */
public class TwoFood2Make extends Base {
    @Override
    public int setView() {
        return R.layout.two_make4;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }
    public void twozhonga(View view){
        Intent intent = new Intent(this,TwoFood2.class);
        startActivity(intent);
        finish();
    }
}
