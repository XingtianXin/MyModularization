package com.example.mymodularization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/app/my_test_activity")
public class MyRouterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_my_router_test);
    }
}
