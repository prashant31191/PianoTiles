package com.czp.pianotiles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.game.ActSPianoGame;
import com.piano.ActPlayPiano;

import java.util.Random;

/**
 * Created by prashant.patel on 9/14/2017.
 */

public class ActSplash extends Activity
{
    boolean isGame = false;
    Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);
        mContext = this;

        playRandomSound();

        Button btnGame = (Button)findViewById(R.id.btnGame);
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGame = true;

                startActivity(new Intent(ActSplash.this, ActSPianoGame.class));
                finish();
            }
        });

        Button btnMini = (Button)findViewById(R.id.btnMini);
        btnMini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGame = true;

                startActivity(new Intent(ActSplash.this, ActWebPiano.class));
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(isGame == false) {
                    //startActivity(new Intent(ActSplash.this, ActWebPiano.class));
                    startActivity(new Intent(ActSplash.this, ActPlayPiano.class));
                    finish();
                }
            }
        },4000);
    }

















    MediaPlayer mp = null;

    int[] sounds = {
            R.raw.s31,
            R.raw.s32,
            R.raw.s33,
            R.raw.s34,
            R.raw.s35,
            R.raw.s36,
            R.raw.s37,
            R.raw.s38,
            R.raw.s39,
            R.raw.s40,

            R.raw.s41,
            R.raw.s42,
            R.raw.s43,
            R.raw.s44,
            R.raw.s45,
            R.raw.s46,
            R.raw.s47,
            R.raw.s48,
            R.raw.s49,
            R.raw.s50,


            R.raw.s51,
            R.raw.s52,
            R.raw.s53,
            R.raw.s54,
            R.raw.s55,
            R.raw.s56,
            R.raw.s57,
            R.raw.s58,
            R.raw.s59,
            R.raw.s60,

            R.raw.s61,
            R.raw.s62,
            R.raw.s63,
            R.raw.s64,
            R.raw.s65,
            R.raw.s66,
            R.raw.s67,
            R.raw.s68,
            R.raw.s69,
            R.raw.s70,

            R.raw.s71,
            R.raw.s72,
            R.raw.s73,
            R.raw.s74,
            R.raw.s75,
            R.raw.s76,


    };
    Random r = new Random();
    int Low = 0;
    int High = 45;
    int rndm = r.nextInt(High-Low) + Low;

    public void playRandomSound()
    {
        try {
            if(mContext !=null && mp == null)
            {
                mp = MediaPlayer.create(mContext, sounds[rndm]);
            }

            if(mp !=null) {
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    rndm = r.nextInt(High - Low) + Low;
                    mp = MediaPlayer.create(mContext, sounds[rndm]);
                }
                mp.start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
