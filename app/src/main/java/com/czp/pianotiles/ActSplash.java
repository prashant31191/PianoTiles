package com.czp.pianotiles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.piano.ActPlayPiano;

/**
 * Created by prashant.patel on 9/14/2017.
 */

public class ActSplash extends Activity
{
    boolean isGame = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);
        Button btnGame = (Button)findViewById(R.id.btnGame);
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGame = true;

                startActivity(new Intent(ActSplash.this, ActGameTile.class));
                finish();
            }
        });

        /*Button btnPlayPiano = (Button)findViewById(R.id.btnPlayPiano);
        btnPlayPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGame = true;

                startActivity(new Intent(ActSplash.this, ActPlayPiano.class));
                finish();
            }
        });*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isGame == false) {
                    //startActivity(new Intent(ActSplash.this, ActWebPiano.class));
                    startActivity(new Intent(ActSplash.this, ActPlayPiano.class));
                    finish();
                }
            }
        },5000);
    }
}
