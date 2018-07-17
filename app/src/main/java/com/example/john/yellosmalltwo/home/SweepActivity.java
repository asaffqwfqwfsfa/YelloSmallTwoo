package com.example.john.yellosmalltwo.home;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.home.fragment.HomeFragment;
import com.example.john.yellosmalltwo.home.fragment.MineFragment;
import com.example.john.yellosmalltwo.home.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SweepActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.but1)
    RadioButton but1;
    @BindView(R.id.but2)
    RadioButton but2;
    @BindView(R.id.rlbuttom)
    RadioGroup rlbuttom;
    @BindView(R.id.iv_zhong)
    RadioButton ivZhong;
    @BindView(R.id.fl)
    FrameLayout fl;
    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweep);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        img.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        ivZhong.setOnClickListener(this);
        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        mineFragment = new MineFragment();
        fragmentManager = getSupportFragmentManager();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                img.setVisibility(View.INVISIBLE);
                fl.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(R.id.fl,homeFragment).commit();
                break;
            case R.id.but1:
                img.setVisibility(View.INVISIBLE);
                fl.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(R.id.fl,orderFragment).commit();
                break;
            case R.id.but2:
                img.setVisibility(View.INVISIBLE);
                fl.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(R.id.fl,mineFragment).commit();
                break;
            case R.id.iv_zhong:
                img.setVisibility(View.VISIBLE);
                fl.setVisibility(View.INVISIBLE);
                break;
        }


    }
}
