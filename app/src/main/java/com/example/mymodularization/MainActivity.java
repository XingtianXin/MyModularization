package com.example.mymodularization;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basemodule.service.Module1ExposeService;
import com.example.basemodule.utils.ARouterConstants;
import com.example.module2.ui.BlankFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = ARouterConstants.MAIN_ACTIVITY)
public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    @Autowired(name = ARouterConstants.MODULE1_EXPOSE_SERVICE)
    public Module1ExposeService myTestService;

    @BindView(R2.id.app_textview)
    TextView appTextView;

    @BindView(R2.id.app_button)
    Button appButton;

    @BindView(R2.id.app_show_module1_info_button)
    Button appShowModule1InfoButton;

    @BindView(R2.id.app_get_m2_fragment_button)
    Button getModule2FragmentButton;

    @BindView(R2.id.app_m2_button)
    Button startModule2Button;

    @OnClick(R2.id.app_button)
    public void onClickEvent(View view) {
        ARouter.getInstance().build(ARouterConstants.MODULE1_ACTIVITY)
                .navigation();
    }

    @OnClick(R2.id.app_show_module1_info_button)
    public void onShowModule1InfoClick(View view) {
        if (myTestService == null) {
            Log.d("XXT", "mTestService is still null");
            return;
        }
        String tempString = myTestService.getModule1Data(this.getLocalClassName());
        appTextView.setText(tempString);
    }

    @OnClick(R2.id.app_get_m2_fragment_button)
    public void getModule2Fragemnt(View view) {
        Fragment m2Fragment = (Fragment) ARouter.getInstance().build(ARouterConstants.MODULE2_BLANK_FRAGMENT).navigation();
        if (m2Fragment == null) {
            Log.d("XXT", "mFragment is null");
            return;
        }
        Toast.makeText(this, "找到Fragment:" + m2Fragment.toString(), Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().add(R.id.root, m2Fragment).commit();
    }

    @OnClick(R2.id.app_m2_button)
    public void startModule2(View view) {
        ARouter.getInstance().build(ARouterConstants.MODULE2_ACTIVITY)
                .navigation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);

        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
