package com.feicui.administrator.hometest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/3.
 */
public class ThickOpenHelper extends SQLiteOpenHelper {
    //数据库版本
    public static final int DATABASE_VERSION = 1;
    //数据库名称
    public static final String DATABASE_NAME = "thick.db";
    //数据库帮助类的构造方法
    public ThickOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //建立表格
        sqLiteDatabase.execSQL(ThickEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //删除表格
        sqLiteDatabase.execSQL(ThickEntry.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
