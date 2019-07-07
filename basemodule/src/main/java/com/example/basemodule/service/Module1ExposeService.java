package com.example.basemodule.service;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface Module1ExposeService extends IProvider {
    String getModule1Data(String s);
}
