package com.feicui.administrator.hometest.food;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.foodmake.EightFood;
import com.feicui.administrator.hometest.foodmake.EightFood2;
import com.feicui.administrator.hometest.foodmake.EightFood3;
import com.feicui.administrator.hometest.foodmake.FiveFood;
import com.feicui.administrator.hometest.foodmake.FiveFood2;
import com.feicui.administrator.hometest.foodmake.FiveFood3;
import com.feicui.administrator.hometest.foodmake.FourFood;
import com.feicui.administrator.hometest.foodmake.FourFood2;
import com.feicui.administrator.hometest.foodmake.FourFood3;
import com.feicui.administrator.hometest.foodmake.NineFood;
import com.feicui.administrator.hometest.foodmake.NineFood2;
import com.feicui.administrator.hometest.foodmake.NineFood3;
import com.feicui.administrator.hometest.foodmake.OneFood;
import com.feicui.administrator.hometest.foodmake.OneFood2;
import com.feicui.administrator.hometest.foodmake.OneFood3;
import com.feicui.administrator.hometest.foodmake.SevenFood;
import com.feicui.administrator.hometest.foodmake.SevenFood2;
import com.feicui.administrator.hometest.foodmake.SevenFood3;
import com.feicui.administrator.hometest.foodmake.SixFood;
import com.feicui.administrator.hometest.foodmake.SixFood2;
import com.feicui.administrator.hometest.foodmake.SixFood3;
import com.feicui.administrator.hometest.foodmake.TenFood;
import com.feicui.administrator.hometest.foodmake.TenFood2;
import com.feicui.administrator.hometest.foodmake.TenFood3;
import com.feicui.administrator.hometest.foodmake.ThreeFood;
import com.feicui.administrator.hometest.foodmake.ThreeFood2;
import com.feicui.administrator.hometest.foodmake.ThreeFood3;
import com.feicui.administrator.hometest.foodmake.TwoFood;
import com.feicui.administrator.hometest.foodmake.TwoFood2;
import com.feicui.administrator.hometest.foodmake.TwoFood3;

/**
 * Created by Administrator on 2016/10/6.
 */
public class Noon extends Base {
    ImageView imzao;
    ImageView imzhong;
    ImageView imwan;
    @Override
    public int setView() {
        return R.layout.noon;
    }

    @Override
    public void initView() {
        imzao= (ImageView) findViewById(R.id.noon_zao);
        imzhong= (ImageView) findViewById(R.id.noon_zhong);
        imwan= (ImageView) findViewById(R.id.noon_wan);
    }

    @Override
    public void setListener() {
            imzao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=getIntent();
                    String zao =intent.getStringExtra("a");
                    Intent intent2;
                    switch (zao){
                        case "1":
                            intent2=new Intent(Noon.this, OneFood.class);
                            startActivity(intent2);
                            finish();
                        break;
                        case "2":
                            intent2=new Intent(Noon.this, TwoFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "3":
                            intent2=new Intent(Noon.this, ThreeFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "4":
                            intent2=new Intent(Noon.this, FourFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "5":
                            intent2=new Intent(Noon.this, FiveFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "6":
                            intent2=new Intent(Noon.this, SixFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "7":
                            intent2=new Intent(Noon.this, SevenFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "8":
                            intent2=new Intent(Noon.this, EightFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "9":
                            intent2=new Intent(Noon.this, NineFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case "10":
                            intent2=new Intent(Noon.this, TenFood.class);
                            startActivity(intent2);
                            finish();
                            break;
                    }
                }
            });
        imzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String zhang =intent.getStringExtra("a");
                Intent intent2;
                switch (zhang){
                    case "1":
                        intent2=new Intent(Noon.this, OneFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "2":
                        intent2=new Intent(Noon.this, TwoFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "3":
                        intent2=new Intent(Noon.this, ThreeFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "4":
                        intent2=new Intent(Noon.this, FourFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "5":
                        intent2=new Intent(Noon.this, FiveFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "6":
                        intent2=new Intent(Noon.this, SixFood2.class);
                        startActivity(intent2);
                        break;
                    case "7":
                        intent2=new Intent(Noon.this, SevenFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "8":
                        intent2=new Intent(Noon.this, EightFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "9":
                        intent2=new Intent(Noon.this, NineFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "10":
                        intent2=new Intent(Noon.this, TenFood2.class);
                        startActivity(intent2);
                        finish();
                        break;
                }
            }
        });

        imwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String wan =intent.getStringExtra("a");
                Intent intent2;
                switch (wan){
                    case "1":
                        intent2=new Intent(Noon.this, OneFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "2":
                        intent2=new Intent(Noon.this, TwoFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "3":
                        intent2=new Intent(Noon.this, ThreeFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "4":
                        intent2=new Intent(Noon.this, FourFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "5":
                        intent2=new Intent(Noon.this, FiveFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "6":
                        intent2=new Intent(Noon.this, SixFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "7":
                        intent2=new Intent(Noon.this, SevenFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "8":
                        intent2=new Intent(Noon.this, EightFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "9":
                        intent2=new Intent(Noon.this, NineFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case "10":
                        intent2=new Intent(Noon.this, TenFood3.class);
                        startActivity(intent2);
                        finish();
                        break;
                }
            }
        });
    }




}
