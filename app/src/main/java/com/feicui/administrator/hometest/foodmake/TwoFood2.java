package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.db.ThickEntry;
import com.feicui.administrator.hometest.food.Base;
import com.feicui.administrator.hometest.food.Noon;

/**
 * Created by Administrator on 2016/10/3.
 */
public class TwoFood2 extends Base {
    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    public int setView() {
        return R.layout.two_food_make2;
    }

    @Override
    public void initView() {
        btn1= (Button) findViewById(R.id.two_zhong_a);
        btn2= (Button) findViewById(R.id.two_zhong_b);
        btn3= (Button) findViewById(R.id.two_zhong_c);
    }

    @Override
    public void setListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoFood2.this, TwoFood2Make.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoFood2.this, TwoFood2Make2.class);
                startActivity(intent);
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoFood2.this, TwoFood2Make3.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void twozhong(View view){
        Intent intent = new Intent(TwoFood2.this, Noon.class);
        intent.putExtra("a","2");
        startActivity(intent);
        finish();
    }



}
