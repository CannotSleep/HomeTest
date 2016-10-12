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
 * Created by Administrator on 2016/10/3.
 */
public class ThreeFood extends Base {
    TextView tv;
    @Override
    public int setView() {
        return R.layout.three_food_make;
    }

    @Override
    public void initView() {
        tv= (TextView) findViewById(R.id.three_food_make_a_tv);
        initList();
    }

    @Override
    public void setListener() {

    }
    public void three(View view){
        Intent intent = new Intent(ThreeFood.this, Noon.class);
        intent.putExtra("a","3");
        startActivity(intent);
        finish();
    }



    public void initList(){
        SQLiteDatabase db =SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH+"/thick.db",null
        );

        Cursor cursor=db.query(
                ThickEntry.THREE_FOOD_A,
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
