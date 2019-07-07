package com.example.module1;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basemodule.base.BaseMvpActivity;
import com.example.basemodule.model.SharedPrefsService;

//import com.example.module1.R2;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjector;

@Route(path = "/module1/Module1Activity")
public class Module1Activity extends BaseMvpActivity {

    @BindView(R2.id.module1_textview1)
    TextView module1Textview1;
    @BindView(R2.id.module1_textview2)
    TextView module1Textview2;
    @BindView(R2.id.modul1_text1)
    ConstraintLayout modul1Text1;

    @Inject
    SharedPrefsService m1SharedPrefs;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_module1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        butterknife.ButterKnife.bind(this);

        initView();
        setTitle("试一试");
    }

    private void initView() {
        module1Textview1.setText(R.string.module1_name);
        module1Textview2.setText(R.string.module1_description_text);
    }

    //应该不需要这个方法就可以，再看看
    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return null;
    }
}
