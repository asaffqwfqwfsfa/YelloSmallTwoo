package com.example.john.yellosmalltwo.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.home.presenter.UpLoadPresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditDataActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iv_back2)
    ImageView ivBack2;
    @BindView(R.id.rl_gerenxinxi)
    RelativeLayout rlGerenxinxi;
    @BindView(R.id.iv_touxiang)
    ImageView ivTouxiang;
    @BindView(R.id.rl_touxiang)
    RelativeLayout rlTouxiang;
    @BindView(R.id.rl_yonghuming)
    RelativeLayout rlYonghuming;
    private UpLoadPresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ivTouxiang.setOnClickListener(this);
        ivBack2.setOnClickListener(this);
        rlTouxiang.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_touxiang:

                break;
            case R.id.iv_back2:
                finish();
                break;
        }
    }
}
