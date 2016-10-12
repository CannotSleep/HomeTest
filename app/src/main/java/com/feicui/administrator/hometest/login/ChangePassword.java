package com.feicui.administrator.hometest.login;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feicui.administrator.hometest.R;
import com.feicui.administrator.hometest.db.ThickEntry;
import com.feicui.administrator.hometest.db.ThickOpenHelper;
import com.feicui.administrator.hometest.food.Base;

/**
 * Created by Administrator on 2016/10/9.
 */
public class ChangePassword extends Base implements View.OnClickListener {
    EditText edt_a;
    EditText edt_b;
    String pass_a;
    String pass_b;
    String name;
    Button btn;
    @Override
    public int setView() {
        return R.layout.activity_password;
    }

    @Override
    public void initView() {
        edt_a = (EditText) findViewById(R.id.change_password);
        edt_b = (EditText) findViewById(R.id.change_password_b);
        btn= (Button) findViewById(R.id.change_btn);
        Intent intent = getIntent();
        name = intent.getStringExtra("username");

    }

    @Override
    public void setListener() {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_btn:
                String pass_a = edt_a.getText().toString();
                String pass_b = edt_b.getText().toString();
                if (pass_a.matches("^[A-Za-z0-9]{0,11}$")) {
                    if (pass_b.matches("^[A-Za-z0-9]{0,11}$")) {
                        if (pass_a.equals(pass_b)) {
                            update(pass_a);
                            Toast.makeText(this, "修改成功", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "两次输入密码不一样", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "第二次输入密码格式不正确", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "密码格式输入不正确", Toast.LENGTH_LONG).show();
                }
            break;

        }

    }

    public void changeback(View view) {
        Intent intent = new Intent(this, Goin.class);
        intent.putExtra("username", name);
        startActivity(intent);
        finish();
    }

    public void update(String password) {
        ThickOpenHelper openHelper = new ThickOpenHelper(this);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ThickEntry.COLUMNS_PASSWORD, password);
        db.update(
                ThickEntry.SUB_USER,
                contentValues,
                ThickEntry.COLUMNS_COUNT + " = " + name,
                null
        );
    }
}
