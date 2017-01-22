package com.voidhug.listview.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.voidhug.listview.R;
import com.voidhug.listview.utils.ActivityUtil;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                ActivityUtil.go(this, Activity1.class);
                finish();
                break;
            case R.id.btn_2:
                ActivityUtil.go(this, Activity2.class);
                finish();
                break;
            case R.id.btn_3:
                ActivityUtil.go(this, Activity3.class);
                finish();
                break;
            case R.id.btn_4:
                ActivityUtil.go(this, Activity4.class);
                finish();
                break;
            case R.id.btn_5:
                ActivityUtil.go(this, Activity5.class);
                finish();
                break;
            default:
                break;
        }
    }
}
