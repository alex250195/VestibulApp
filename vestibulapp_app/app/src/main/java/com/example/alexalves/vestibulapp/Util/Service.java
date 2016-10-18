package com.example.alexalves.vestibulapp.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Desenvolvedor on 17/10/2016.
 */

public class Service {

    public static boolean isOnline(Context _cx) {
        if(_cx != null) {
            ConnectivityManager cm = (ConnectivityManager) _cx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }
}
