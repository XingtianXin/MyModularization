package com.example.module1.service;

import android.content.Context;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.basemodule.service.Module1ExposeService;
import com.example.basemodule.utils.Log;

@Route(path = "/module1/Module1Service")
public class Module1ServiceImpl implements Module1ExposeService {
    private static final String TAG = "XXT";
    @Override
    public String getModule1Data(String s) {
        Log.d(TAG + "this is print from base module Log " + s);
        return "M1Service is called by "+s;
    }

    @Override
    public void init(Context context) {

    }
}
