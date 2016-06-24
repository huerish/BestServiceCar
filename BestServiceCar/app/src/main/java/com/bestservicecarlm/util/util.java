package com.bestservicecarlm.util;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by lchan on 20/06/2016.
 */
public class util {

    public static void sendAndFinish(Activity activity, Class clase){
        Intent mainIntent = new Intent().setClass(activity, clase);
        activity.startActivity(mainIntent);
        activity.finish();
    }

    public static void sendTo(Activity activity, Class clase){
        Intent mainIntent = new Intent().setClass(activity, clase);
        activity.startActivity(mainIntent);
    }
}
