package com.feicui.administrator.hometest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/2.
 */
public class BeginActivity extends Activity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_begin);
        imageView= (ImageView) findViewById(R.id.begin_im);
        initAnim();
    }

    public void initAnim(){
        ValueAnimator animator = ObjectAnimator.ofFloat(imageView,"alpha",0.0f,1.0f);
        animator.setDuration(3000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Intent intent = new Intent(BeginActivity.this,ChangeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        animator.start();

    }
}
