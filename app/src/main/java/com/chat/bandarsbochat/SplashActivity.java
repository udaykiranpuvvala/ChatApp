package com.chat.bandarsbochat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chat.bandarsbochat.utilities.Constants;


public class SplashActivity extends AppCompatActivity {

    ImageView ivGif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivGif = (ImageView)findViewById(R.id.ivGif);

        //GlideDrawableImageViewTarget splashScreen = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.loading).into(ivGif);

        Handler mSplashHandler = new Handler();
        Runnable action = new Runnable() {
            @Override
            public void run() {
               /* if (!Utility.hasPermissions(SplashActivity.this, PERMISSIONS)) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(PERMISSIONS, 1);
                    }
                } else {*/
                naigateActivity();
//                }

            }
        };
        mSplashHandler.postDelayed(action, Constants.SPLASH_TIME_OUT);

    }

    private void naigateActivity() {
//        startActivity(new Intent(SplashActivity.this, QuestionActivity.class));
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
