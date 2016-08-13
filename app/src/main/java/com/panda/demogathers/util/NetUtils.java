package com.panda.demogathers.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by admin on 2016/8/3.
 */
public class NetUtils {


    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetworkInfo.isConnected()) {
            return true;
        }else {
            Toast.makeText(context,"建议打开wifi,用wifi链接",Toast.LENGTH_SHORT).show();
        return false;

        }
    }

}
