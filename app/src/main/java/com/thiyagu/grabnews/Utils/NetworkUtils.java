package com.thiyagu.grabnews.Utils;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.thiyagu.grabnews.BaseApplication;
public class NetworkUtils {
    public static String TAG = "NetworkUtils";
    public static boolean isInternetConnectivityAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.baseApplication.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        } catch (Exception e) {
            Log.e(TAG + "isNetworkAvailable()", e.toString());
        }
        return false;
    }
}
