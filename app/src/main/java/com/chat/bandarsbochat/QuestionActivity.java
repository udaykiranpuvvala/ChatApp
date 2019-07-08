package com.chat.bandarsbochat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.chat.bandarsbochat.utilities.PopUtilities;
import com.chat.bandarsbochat.utilities.Utility;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSubmit;
    RadioButton rdBtnFacebook, rdBtnGoogle, rdBtnLinkedIn, rdBtnTwitter;
    String rBnValue = "";
    ImageView ivBlackBerry, ivWhatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initUI();
    }

    private void initUI() {

        ivWhatsApp = (ImageView) findViewById(R.id.ivWhatsApp);
        ivBlackBerry = (ImageView) findViewById(R.id.ivBlackBerry);


        txtSubmit = (TextView) findViewById(R.id.txtSubmit);
        rdBtnFacebook = (RadioButton) findViewById(R.id.rdBtnFacebook);
        rdBtnGoogle = (RadioButton) findViewById(R.id.rdBtnGoogle);
        rdBtnLinkedIn = (RadioButton) findViewById(R.id.rdBtnLinkedIn);
        rdBtnTwitter = (RadioButton) findViewById(R.id.rdBtnTwitter);

        ivBlackBerry.setOnClickListener(this);
        ivWhatsApp.setOnClickListener(this);

        txtSubmit.setOnClickListener(this);
        rdBtnFacebook.setOnClickListener(this);
        rdBtnGoogle.setOnClickListener(this);
        rdBtnLinkedIn.setOnClickListener(this);
        rdBtnTwitter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBlackBerry: {
                PopUtilities.showBlackBerryDialog(this);
                break;
            }
            case R.id.ivWhatsApp: {
                PackageManager packageManager = getPackageManager();
                Intent i = new Intent(Intent.ACTION_VIEW);
                String phone = "+6281290808898";
                try {
                    // String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
                    String url = "https://api.whatsapp.com/send?phone=" + phone; //&text="// + URLEncoder.encode(message, "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        startActivity(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case R.id.txtSubmit: {
                if (!Utility.isValueNullOrEmpty(rBnValue)) {
                    startActivity(new Intent(this, ViewTextActivity.class));
                } else {
                    Utility.setSnackBarEnglish(this, txtSubmit, "silahkan mengis kolom yang diwajibkan", QuestionActivity.this);
                }
                break;
            }
            case R.id.rdBtnFacebook: {
                rBnValue = "Facebook";
                break;
            }
            case R.id.rdBtnGoogle: {
                rBnValue = "Google";
                break;
            }
            case R.id.rdBtnLinkedIn: {
                rBnValue = "Linkedin";
                break;
            }
            case R.id.rdBtnTwitter: {
                rBnValue = "Twitter";
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        PopUtilities.showExitDialog(this, this.getResources().getString(R.string.are_u_sure_close_application));
    }
}
