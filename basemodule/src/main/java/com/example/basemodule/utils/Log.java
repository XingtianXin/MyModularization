package com.example.basemodule.utils;

import com.example.basemodule.BuildConfig;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/5
 * Time: 14:12
 */
public class Log {

    public static void d(String text) {
        if (BuildConfig.DEBUG) {
            String[] logStrings = createLogStrings(text);
            android.util.Log.d(logStrings[0], logStrings[1]);
        }
    }

    public static void e(String text) {
        Log.e(text, null);
    }


    public static void e(String text, Throwable e) {
        if (BuildConfig.DEBUG) {
            String[] logStrings = createLogStrings(text);
            android.util.Log.e(logStrings[0], logStrings[1], e);
        }
    }

    public static void w(String text) {
        if (BuildConfig.DEBUG) {
            String[] logStrings = createLogStrings(text);
            android.util.Log.w(logStrings[0], logStrings[1]);
        }
    }

    public static void i(String text) {
        if (BuildConfig.DEBUG) {
            String[] logStrings = createLogStrings(text);
            android.util.Log.i(logStrings[0], logStrings[1]);
        }
    }

    private static String[] createLogStrings(String text) {
        String[] result = new String[2];

        StackTraceElement[] ste = Thread.currentThread().getStackTrace();

        result[0] = "(" + (ste[4].getFileName() + ":" + ste[4].getLineNumber() + ")");
        result[1] = ste[4].getMethodName() + ": " + text;
        return result;
    }
}
