package com.chat.bandarsbochat.utilities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

import com.chat.bandarsbochat.R;
/**
 * Created by uday kiran on 10-04-2017.
 */

public class PopUtilities {

    public static Dialog dialog;

    public static void showExitDialog(final Context context, String text) {
        final Dialog dialogEventConfirmation = new Dialog(context);
        dialogEventConfirmation.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
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

        txt_dialog_message.setText(text);
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEventConfirmation.dismiss();

                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(a);
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
    public static void showBlackBerryDialog(final Context context) {
        final Dialog dialogEventConfirmation = new Dialog(context);
        dialogEventConfirmation.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialogEventConfirmation.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEventConfirmation.setContentView(R.layout.dialog_show_blackberry);
        //dialogEventConfirmation.getWindow().setGravity(Gravity.BOTTOM);
        dialogEventConfirmation.setCanceledOnTouchOutside(true);
        //dialogEventConfirmation.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialogEventConfirmation.getWindow().setBackgroundDrawable(new
                ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView txt_dialog_message = (TextView) dialogEventConfirmation.findViewById(R.id.txt_dialog_message);
        TextView tv_yes = (TextView) dialogEventConfirmation.findViewById(R.id.tv_yes);
        TextView tv_no = (TextView) dialogEventConfirmation.findViewById(R.id.tv_no);

        txt_dialog_message.setText("Huruf besar semua");
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEventConfirmation.dismiss();

                Intent a = new Intent(Intent.ACTION_MAIN);
                a.addCategory(Intent.CATEGORY_HOME);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(a);
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
    public static String decodeBase64(String coded) {
        byte[] valueDecoded = new byte[0];
        try {
            valueDecoded = Base64.decode(coded.getBytes("UTF-8"), Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            Utility.showLog("Error", "" + e);
        }
        return new String(valueDecoded);
    }


   /* public static void alertDialog(final Context mContext, String message, final View.OnClickListener okClick) {
        TextView mTxtOk, mTxtMessage;
        final Dialog dialog = new Dialog(mContext, R.style.AlertDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View v = LayoutInflater.from(mContext).inflate(R.layout.alert_dialog, null);
        mTxtOk = (TextView) v.findViewById(R.id.txtNo);
        mTxtMessage = (TextView) v.findViewById(R.id.txtMessage);

        dialog.getWindow().getAttributes().windowAnimations = R.style.AlertDialogCustom;
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        mTxtMessage.setText(message);
        mTxtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (okClick != null) {
                    okClick.onClick(v);
                }
            }
        });

        dialog.setContentView(v);
        dialog.setCancelable(false);

        int width = (int) (mContext.getResources().getDisplayMetrics().widthPixels * 0.90);
        int height = (int) (mContext.getResources().getDisplayMetrics().heightPixels * 0.30);
        dialog.getWindow().setLayout(width, lp.height);
        dialog.show();
    }
*/
}
