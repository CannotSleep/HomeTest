package com.feicui.administrator.hometest.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feicui.administrator.hometest.MainActivity;
import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.db.ThickEntry;
import com.feicui.administrator.hometest.entity.User;
import com.feicui.administrator.hometest.food.Base;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/10.
 */
public class  Goin extends Base {
    TextView tv;
    String name;

    @Override
    public int setView() {
        return R.layout.activity_goin;
    }

    @Override
    public void initView() {
        tv= (TextView) findViewById(R.id.goin_tv);
        Intent intent2=getIntent();
        name=intent2.getStringExtra("username");
        tv.setText(name);
    }

    @Override
    public void setListener() {

    }

    public void gobackgoin(View view){
        Intent intent = new Intent(Goin.this, MainActivity.class);
        intent.putExtra("login","1");
        intent.putExtra("username",name);
        startActivity(intent);
        finish();
    }

    public void change(View view){
        Intent intent =new Intent(Goin.this,ChangePassword.class);
        intent.putExtra("username",name);
        startActivity(intent);


    }


}
