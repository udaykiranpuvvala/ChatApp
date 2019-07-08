package com.chat.bandarsbochat;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.chat.bandarsbochat.utilities.PopUtilities;
import com.livechatinc.inappchat.ChatWindowConfiguration;
import com.livechatinc.inappchat.ChatWindowView;
import com.livechatinc.inappchat.models.NewMessageModel;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements ChatWindowView.ChatWindowEventsListener, View.OnClickListener {

    ChatWindowConfiguration configuration;
    ChatWindowView fullScreenChatWindow;
    ChatWindowView emmbeddedChatWindow;
    ImageView ivBlackBerry, ivWhatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivWhatsApp = (ImageView) findViewById(R.id.ivWhatsApp);
        ivBlackBerry = (ImageView) findViewById(R.id.ivBlackBerry);


        ivBlackBerry.setOnClickListener(this);
        ivWhatsApp.setOnClickListener(this);


        Map<String,String> customParamsMap = new HashMap<>();
        customParamsMap.put("name","Simha");


       // emmbeddedChatWindow  = new ChatWindowView(MainActivity.this);
        emmbeddedChatWindow = findViewById(R.id.embedded_chat_window);

        configuration = new ChatWindowConfiguration(
                "9287135",
                "group_id",
                "Guest",
                "guest@gmail.com",
                (HashMap<String, String>) customParamsMap
        );

        startEmmbeddedChat();


//        startFullScreenChat();
    }

    public void startEmmbeddedChat() {
        if (!emmbeddedChatWindow.isInitialized()) {
            emmbeddedChatWindow.setUpWindow(configuration);
            emmbeddedChatWindow.setUpListener(this);
            emmbeddedChatWindow.initialize();
        }
        emmbeddedChatWindow.showChatWindow();
    }

    public void startFullScreenChat() {
        if (fullScreenChatWindow == null) {
            fullScreenChatWindow = ChatWindowView.createAndAttachChatWindowInstance(this);
            fullScreenChatWindow.setUpWindow(configuration);
            fullScreenChatWindow.setUpListener(this);
            fullScreenChatWindow.initialize();
        }
        fullScreenChatWindow.showChatWindow();
    }

    @Override
    public void onChatWindowVisibilityChanged(boolean b) {

    }

    @Override
    public void onNewMessage(NewMessageModel newMessageModel, boolean b) {

    }

    @Override
    public void onStartFilePickerActivity(Intent intent, int i) {

    }

    @Override
    public boolean handleUri(Uri uri) {
        return false;
    }

    @Override
    public void onBackPressed() {
        //return fullScreenChatWindow != null && fullScreenChatWindow.onBackPressed();
        //PopUtilities.showExitDialog(this,this.getResources().getString(R.string.are_u_sure_close_application));
        final Dialog dialogEventConfirmation = new Dialog(this);
       // dialogEventConfirmation.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogEventConfirmation.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEventConfirmation.setContentView(R.layout.dialog_exit_confirmation);
        //dialogEventConfirmation.getWindow().setGravity(Gravity.BOTTOM);
        dialogEventConfirmation.setCanceledOnTouchOutside(true);
        //dialogEventConfirmation.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialogEventConfirmation.getWindow().setBackgroundDrawable(new
                ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView txt_dialog_message = (TextView) dialogEventConfirmation.findViewById(R.id.txt_dialog_message);
        TextView tv_yes = (TextView) dialogEventConfirmation.findViewById(R.id.tv_yes);
        TextView tv_no = (TextView) dialogEventConfirmation.findViewById(R.id.tv_no);

        txt_dialog_message.setText(this.getResources().getString(R.string.are_u_sure_close_application));
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEventConfirmation.dismiss();
                finishAffinity();
/*
                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(a);*/
            }
        });

        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogEventConfirmation.dismiss();
            }
        });

        dialogEventConfirmation.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (fullScreenChatWindow != null) fullScreenChatWindow.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
            default:
                break;
        }
    }
}
