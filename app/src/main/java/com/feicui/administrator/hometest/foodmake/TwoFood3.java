package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.food.Base;
import com.feicui.administrator.hometest.food.Noon;

/**
 * Created by Administrator on 2016/10/6.
 */
public class TwoFood3 extends Base {
    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    public int setView() {
        return R.layout.two_food_make3;
    }

    @Override
    public void initView() {
        btn1= (Button) findViewById(R.id.two_wan_a);
        btn2= (Button) findViewById(R.id.two_wan_b);
        btn3= (Button) findViewById(R.id.two_wan_c);
    }

    @Override
    public void setListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoFood3.this,TwoFood3Make.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoFood3.this,TwoFood3Make2.class);
                startActivity(intent);
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoFood3.this,TwoFood3Make3.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void wan(View view){
        Intent intent = new Intent(TwoFood3.this, Noon.class);
        intent.putExtra("a","2");
        startActivity(intent);
        finish();
    }
}
