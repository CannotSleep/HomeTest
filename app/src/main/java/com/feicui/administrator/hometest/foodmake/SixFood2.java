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
public class SixFood2 extends Base {
    TextView tv1;
    TextView tv2;
    @Override
    public int setView() {
        return R.layout.six_food_make2;
    }

    @Override
    public void initView() {
        tv1= (TextView) findViewById(R.id.six_food_b_a_tv);
        tv2= (TextView) findViewById(R.id.six_food_b_b_tv);
        initList();
        initList1();
    }

    @Override
    public void setListener() {

    }
    public void sixb(View view){
        Intent intent = new Intent(SixFood2.this, Noon.class);
        intent.putExtra("a","6");
        startActivity(intent);
        finish();
    }
    public void initList(){
        SQLiteDatabase db =SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH+"/thick.db",null
        );
        Cursor cursor=db.query(
                ThickEntry.SIX_FOOD_B,
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
                ThickEntry.SIX_FOOD_C,
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
