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
 * Created by Administrator on 2016/10/7.
 */
public class FourFood3 extends Base {
    TextView tv;
    @Override
    public int setView() {
        return R.layout.four_food_make3;
    }

    @Override
    public void initView() {
        tv= (TextView) findViewById(R.id.four_food_make3_tv);
        initList();
    }

    @Override
    public void setListener() {

    }
    public void fourc(View view){
        Intent intent =new Intent(FourFood3.this, Noon.class);
        intent.putExtra("a","4");
        startActivity(intent);
        finish();
    }
    public void initList(){
        SQLiteDatabase db =SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH+"/thick.db",null
        );

        Cursor cursor=db.query(
                ThickEntry.FOUR_FOOD_C,
                new String[]{"*"},
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        String cation=cursor.getString(cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_MAKE));
        tv.setText(cation);
    }
}
