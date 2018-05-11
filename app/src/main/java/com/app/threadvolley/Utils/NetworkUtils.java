package com.app.threadvolley.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Vrajan on 22-09-2017.
 */

public class NetworkUtils {

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo netInfo = getNetworkInfo(context);
        return netInfo != null && netInfo.isConnected();
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo;
    }
}
