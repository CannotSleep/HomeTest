package com.feicui.administrator.hometest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.feicui.administrator.hometest.login.Login;

/**
 * Created by Administrator on 2016/10/2.
 */
public class ChangeActivity extends Activity {
    ImageView imageView_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        imageView_change= (ImageView) findViewById(R.id.change_im);
        judge();
    }

    public void judge(){
        int a =Math.round((float) Math.random()*3);
        switch (a){
            case 0:
                imageView_change.setImageResource(R.drawable.upa);
                break;
            case 1:
                imageView_change.setImageResource(R.drawable.upb);
                break;
            case 2:
                imageView_change.setImageResource(R.drawable.upc);
                break;
            case 3:
                imageView_change.setImageResource(R.drawable.upd);
                break;
        }
    }

    public void jump(View view){
        Intent intent =new Intent(ChangeActivity.this,Login.class);
        startActivity(intent);
        finish();
    }

}
