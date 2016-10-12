package com.feicui.administrator.hometest.foodmake;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.TextView;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.db.ThickEntry;
import com.feicui.administrator.hometest.food.Base;
import com.feicui.administrator.hometest.food.Noon;

/**
 * Created by Administrator on 2016/10/6.
 */
public class EightFood extends Base {
    TextView tv1;
    TextView tv2;
    @Override
    public int setView() {
        return R.layout.eight_food_make;
    }

    @Override
    public void initView() {
        tv1= (TextView) findViewById(R.id.eight_food_a_a_tv);
        tv2= (TextView) findViewById(R.id.eight_food_a_b_tv);
        initList();
        initList1();
    }

    @Override
    public void setListener() {

    }
    public void eighta(View view){
        Intent intent = new Intent(EightFood.this, Noon.class);
        intent.putExtra("a","8");
        startActivity(intent);
        finish();
    }

    public void initList(){
        SQLiteDatabase db =SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH+"/thick.db",null
        );
        Cursor cursor=db.query(
                ThickEntry.EIGHT_FOOD_A,
                new String[]{"*"},
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        String cation=cursor.getString(cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_MAKE));
        tv1.setText(cation);
    }
    public void initList1(){
        SQLiteDatabase db =SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH+"/thick.db",null
        );
        Cursor cursor=db.query(
                ThickEntry.EIGHT_FOOD_B,
                new String[]{"*"},
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        String cation=cursor.getString(cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_MAKE));
        tv2.setText(cation);
    }
}
