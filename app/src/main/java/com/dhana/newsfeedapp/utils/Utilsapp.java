package com.dhana.newsfeedapp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


/**********************************************
 * Created by dhana on 25/06/22.
 **********************************************/
public class Utilsapp {
    static Boolean ISDEBUGGING = true;
    private static String TAGG = Utilsapp.class.getSimpleName();
    private static ProgressDialog mProgressDialog;
    public static Dialog exit_dialog;

    /********************************************************
     * @Function:showLog()
     * @Description:To show the debug log
     * *******************************************************/
    public static void showLog(String TAG, String msg) {
        if (ISDEBUGGING) {
            try {
                Log.d(TAG, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*********************************************************
     * Show debug Error Message into logcat
     * @param TAG
     * @param msg
     ********************************************************/
    public static void showErrorLog(String TAG, String msg) {
        if (ISDEBUGGING) {
            Log.e(TAG, msg);
        }
    }

    /********************************************************
     * @Function:showtoast()
     * @Description:To display the toast messsage of the application
     * *******************************************************/
    public static void showtoast(final Activity mActivity, final String msg) {
        try {
            if (mActivity != null && msg != null && msg.length() > 0) {
                mActivity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show_alerttoast(final Activity mActivity, final String msg) {
        try {
            if (mActivity != null && msg != null && msg.length() > 0) {
                mActivity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT);
                        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//                            v.setTextSize(tv_size);
                        v.setTypeface(null, Typeface.BOLD);
                        v.setTextColor(Color.RED);
                        toast.show();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
