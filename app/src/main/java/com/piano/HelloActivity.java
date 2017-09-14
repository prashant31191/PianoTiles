package com.piano;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.czp.pianotiles.R;
import com.piano.utils.SysApplication;


public class HelloActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        SysApplication.getInstance().addActivity(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(HelloActivity.this, ActPlayPiano.class);
                startActivity(intent);
            }
        }, 1000);
    }
}
