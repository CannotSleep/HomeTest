package com.feicui.administrator.hometest.login;

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
import com.feicui.administrator.hometest.entity.User;
import com.feicui.administrator.hometest.food.Base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/8.
 */
public class Login extends Base implements View.OnClickListener {
    EditText edt_user;
    EditText edt_pass;
    Button btn_login;
    Button btn_design;
    Boolean isOk;

    @Override
    public int setView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        edt_user = (EditText) findViewById(R.id.login_username);
        edt_pass = (EditText) findViewById(R.id.login_password);
        btn_design = (Button) findViewById(R.id.login_design_btn);
        btn_login = (Button) findViewById(R.id.login_login_btn);
        importDatabase();
        initList();
    }

    @Override
    public void setListener() {
        btn_login.setOnClickListener(this);
        btn_design.setOnClickListener(this);
    }


    public void problem(View view) {
        Toast.makeText(this, "请检查网络", Toast.LENGTH_LONG).show();
    }

    public void design(View view) {
        Intent intent = new Intent(this, Design.class);
        startActivity(intent);
        finish();
    }

    public void forget(View view) {
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
        finish();
    }

//    public void goback(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }

    private void importDatabase() {
        try {
            //根据固定路径创建数据库目录，若数据库目录不存在，创建单层目录
            File dirFile = new File(ThickEntry.DATABASE_PATH);
            if (!dirFile.exists()) {
                dirFile.mkdir();
            }
            //创建被导入的数据库File对象
            File file = new File(ThickEntry.DATABASE_PATH, "thick.db");
            //判断文件是否存在，如不存在则创建该文件，存在就直接返回
            if (!file.exists()) {
                file.createNewFile();
            } else {
                return;
            }
            //获得加载数据库文件的输入流
            InputStream in = getResources().openRawResource(R.raw.thick);
            //创建将被导入的数据库输出流
            FileOutputStream out = new FileOutputStream(file);
            //创建缓冲区
            byte[] buffer = new byte[1024];
            //将数据读入缓冲区，并写入输出流
            while (in.read(buffer) != -1) {
                //将缓冲区中的数据写入输出流
                out.write(buffer);
                //更新缓冲区
                buffer = new byte[1024];
            }
            //关闭输入输出流
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_login_btn:
                String user = edt_user.getText().toString();
                String password = edt_pass.getText().toString();
                if (!user.equals(null)) {
                    if (!password.equals(null)) {
                        if (user.matches("^[A-Za-z0-9]{0,11}$")) {
                            if (password.matches("[A-Za-z0-9]{0,11}$")) {
                                for (int i = 0; i < listlogin.size(); i++) {
                                    if (user.equals(listlogin.get(i).getCount()) && password.equals(listlogin.get(i).getPassword())) {
                                        isOk = true;
                                        if (isOk) {
                                            Intent intent = new Intent(Login.this, MainActivity.class);
                                            //此处需要传递数据
                                            //intent.putExtra("login", "1");
                                            intent.putExtra("username", user);
                                            startActivity(intent);
                                            finish();
                                        }
                                    } else {
//                                        if (!user.equals(initList().get(initList().size() - 1).getCount()) && !password.equals(initList().get(initList().size() - 1).getPassword())) {
//                                            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_LONG).show();
//                                        }
                                    }
                                }
                            } else {
                                Toast.makeText(this, "密码格式错误", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(this, "用户名格式错误", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "密码不能为空", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.login_design_btn:
                Intent intent = new Intent(this, Design.class);
                startActivity(intent);
                finish();
                break;


        }
    }

    ArrayList<User> listlogin = new ArrayList<User>();

    public void initList() {
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
        cursor.close();
        listlogin = datalist;
    }
}
