package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.food.Base;
import com.feicui.administrator.hometest.food.Noon;

/**
 * Created by Administrator on 2016/10/3.
 */
public class OneFood extends Base {
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public int setView() {
        return R.layout.one_food_make;
    }

    @Override
    public void initView() {
        btn1 = (Button) findViewById(R.id.one_zao_a);
        btn2 = (Button) findViewById(R.id.one_zao_b);
        btn3 = (Button) findViewById(R.id.one_zao_c);
    }

    @Override
    public void setListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneFood.this,OneFoodMake.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneFood.this,OneFoodMake2.class);
                startActivity(intent);
                finish();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneFood.this,OneFoodMake3.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void jumpbackonefooda(View view) {
        Intent intent = new Intent(OneFood.this, Noon.class);
        intent.putExtra("a","1");
        startActivity(intent);
        finish();
    }

}
