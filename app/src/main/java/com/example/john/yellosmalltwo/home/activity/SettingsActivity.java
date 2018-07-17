package com.example.john.yellosmalltwo.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.iv_back2)
    ImageView ivBack2;
    @BindView(R.id.tv_huancun)
    TextView tvHuancun;
    @BindView(R.id.rl_touxiang)
    RelativeLayout rlTouxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
    }
}
