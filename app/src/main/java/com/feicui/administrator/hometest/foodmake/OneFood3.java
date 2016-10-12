package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.food.Base;
import com.feicui.administrator.hometest.food.Noon;

/**
 * Created by Administrator on 2016/10/6.
 */
public class OneFood3 extends Base {
    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    public int setView() {
        return R.layout.one_food_make3;
    }

    @Override
    public void initView() {
        btn1= (Button) findViewById(R.id.one_wan_a);
        btn2= (Button) findViewById(R.id.one_wan_b);
        btn3= (Button) findViewById(R.id.one_wan_c);
    }

    @Override
    public void setListener() {
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(OneFood3.this,OneFood3Make.class);
                    startActivity(intent);
                    finish();
                }
            });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(OneFood3.this,OneFood3Make2.class);
                startActivity(intent);
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(OneFood3.this,OneFood3Make3.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void jumpwan(View view){
        Intent intent = new Intent(OneFood3.this, Noon.class);
        intent.putExtra("a","1");
        startActivity(intent);
        finish();
    }

}
