package com.example.hp.onlineshopping.UI.Activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.hp.onlineshopping.UI.Base.BaseActivity;
import com.example.hp.onlineshopping.R;

public class SplachActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplachActivity.this,LoginActivity.class));
                        finish();
                    }
                }, 3000);
    }
}
