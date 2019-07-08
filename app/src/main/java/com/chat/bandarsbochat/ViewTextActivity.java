package com.chat.bandarsbochat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.chat.bandarsbochat.utilities.Constants;


public class ViewTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_text);

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
        startActivity(new Intent(ViewTextActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}
