package com.feicui.administrator.hometest.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feicui.administrator.hometest.MainActivity;
import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.db.ThickEntry;
import com.feicui.administrator.hometest.db.ThickOpenHelper;
import com.feicui.administrator.hometest.entity.User;
import com.feicui.administrator.hometest.food.Base;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/10.
 */
public class Design extends Base implements View.OnClickListener {
    EditText count;
    EditText password;
    EditText password2;
    String count_str;
    String password_str;
    String password2_str;
    Button btn;
    Boolean ok;

    @Override
    public int setView() {
        return R.layout.activity_design;
    }

    @Override
    public void initView() {
        count = (EditText) findViewById(R.id.design_username);
        password = (EditText) findViewById(R.id.design_password);
        password2 = (EditText) findViewById(R.id.design_password_b);
        btn = (Button) findViewById(R.id.design_btn);

    }

    @Override
    public void setListener() {
            btn.setOnClickListener(this);
    }

    public void design() {
        count_str = count.getText().toString();
        password_str = password.getText().toString();
        password2_str = password2.getText().toString();
        if (!count_str.equals(null)) {
            if (!password_str.equals(null)) {
                if (!password2_str.equals(null)) {
                    if (count_str.matches("^[A-Za-z0-9]{0,11}$")) {
                        if (password_str.matches("^[A-Za-z0-9]{0,11}$")) {
                            for (int i = 0; i < initList().size(); i++) {
                                if (count_str.equals(initList().get(i).getCount())) {
                                    ok = false;
                                    Toast.makeText(this, "用户已存在", Toast.LENGTH_LONG);
                                } else {
                                    ok = true;
                                }
                            }
                        } else {
                            Toast.makeText(this, "密码格式不正确", Toast.LENGTH_LONG);
                        }
                    } else {
                        Toast.makeText(this, "用户名格式不正确", Toast.LENGTH_LONG);
                    }
                } else {
                    Toast.makeText(this, "第二次密码不可以为空", Toast.LENGTH_LONG);
                }
            } else {
                Toast.makeText(this, "密码不可以为空", Toast.LENGTH_LONG);
            }
        } else {
            Toast.makeText(this, "用户名不可以为空", Toast.LENGTH_LONG);
        }
    }

    private ArrayList<User> initList() {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
                ThickEntry.DATABASE_PATH + "/thick.db", null);
        Cursor cursor = db.query(
                ThickEntry.SUB_USER,
                new String[]{ThickEntry.COLUMNS_COUNT, ThickEntry.COLUMNS_PASSWORD},
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        final ArrayList<User> datalist = new ArrayList<User>();
        do {
            //获得学号
            String count = cursor.getString(cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_COUNT));
            //获得密码
            String password = cursor.getString(cursor.getColumnIndexOrThrow(ThickEntry.COLUMNS_PASSWORD));
            User user = new User();
            user.setCount(count);
            user.setPassword(password);
            datalist.add(user);
        } while (cursor.moveToNext());
        return datalist;
    }

    public void success() {
            ThickOpenHelper thickOpenHelper = new ThickOpenHelper(this);
            SQLiteDatabase db = thickOpenHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ThickEntry.COLUMNS_COUNT, count_str);
            contentValues.put(ThickEntry.COLUMNS_PASSWORD, password_str);
            db.insert(
                    ThickEntry.SUB_USER,
                    null,
                    contentValues
            );
            Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.design_btn:
                 design();
                 success();
                    Intent intent = new Intent(this,Login.class);
                    //intent.putExtra("login","1");
                    startActivity(intent);
                    finish();
                break;
        }
    }
    public void designback(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }


}
