package com.example.module2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basemodule.base.BaseMvpActivity;
import com.example.basemodule.utils.ARouterConstants;

@Route(path = ARouterConstants.MODULE2_ACTIVITY)
public class Module2Activity extends BaseMvpActivity<Module2Presenter> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_module2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }
}
