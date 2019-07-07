package com.example.basemodule.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/4
 * Time: 16:52
 */
public class SharedPrefsService {
    private static final String TAG = SharedPrefsService.class.getSimpleName();
    private static final String SharedPreferencesName = "AAAAAAABBBBBB";

    private static final String TEST_SHARE_PREFS_KEY = "test_share_prefs_key";

    private SharedPreferences sharedPreferences;

    public SharedPrefsService(Context mContext) {
        if (mContext != null) {
            sharedPreferences = mContext.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
        } else {
            Log.e(TAG, "WARMING! You must init SharedPreferencesDao in your Application ！");
        }
    }

    public <T> T getData(String key, @NonNull Object defValue, @NonNull Class<T> clazz) {
        T t = null;
        if (!defValue.getClass().getSimpleName().equals(clazz.getSimpleName())) {
            throw new UnsupportedOperationException("defValue type does not equals whit clazz "); //转换将失败！
        }

        switch (clazz.getSimpleName()) {
            case "String":
                t = (T) sharedPreferences.getString(key, (String) defValue);
                break;
            case "Integer":
                t = (T) (Integer) sharedPreferences.getInt(key, (Integer) defValue);
                break;
            case "Float":
                t = (T) (Float) sharedPreferences.getFloat(key, (Float) defValue);
                break;
            case "Long":
                t = (T) (Long) sharedPreferences.getLong(key, (Long) defValue);
                break;
            case "Boolean":
                t = (T) (Boolean) sharedPreferences.getBoolean(key, (Boolean) defValue);
                break;
        }
        return t;
    }

    public void saveData(String key, @NonNull Object value) {
        if (value instanceof String) {
            sharedPreferences.edit().putString(key, (String) value).commit();
        } else if (value instanceof Integer) {
            sharedPreferences.edit().putInt(key, (Integer) value).commit();
        } else if (value instanceof Float) {
            sharedPreferences.edit().putFloat(key, (Float) value).commit();
        } else if (value instanceof Long) {
            sharedPreferences.edit().putLong(key, (Long) value).commit();
        } else if (value instanceof Boolean) {
            sharedPreferences.edit().putBoolean(key, (Boolean) value).commit();
        }
    }
}
