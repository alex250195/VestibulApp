package com.example.alexalves.vestibulapp.Util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.alexalves.vestibulapp.R;

/**
 * Created by Desenvolvedor on 17/06/2016.
 */
public class Dialog {

    public static void Show(Context _cx,  String _message, String _title) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(_cx);
        alert.setTitle(_title);
        alert.setMessage(_message);
        alert.setNegativeButton(_cx.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.setCancelable(true);
            }
        });
        alert.show();
    }

    public static void ShowProgressDialog(ProgressDialog _progress, String _msg){

        if(_progress != null && !_progress.isShowing()) {

            _progress.setMessage(_msg);
            _progress.setCanceledOnTouchOutside(false);
            _progress.setCancelable(false);
            _progress.show();

        }

    }

}
