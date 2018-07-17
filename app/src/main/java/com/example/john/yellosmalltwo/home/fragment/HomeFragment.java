package com.example.john.yellosmalltwo.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.home.activity.ProductActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/7/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
@BindView(R.id.iv_caidanlist)
ImageView ivCaidanlist;
@BindView(R.id.tv_title)
TextView tvTitle;
@BindView(R.id.tl)
TabLayout tl;
@BindView(R.id.vp)
ViewPager vp;

            Unbinder unbinder;
private List<String> list=new ArrayList<>();
private List<Fragment> fragmentsList;

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this,view);
        ivCaidanlist.setOnClickListener(this);
        initData();
        return view;
        }

private void initData() {
        list.add("热点");
        list.add("主食");
        list.add("招牌");
        list.add("饮品");
        list.add("小吃");
        vp.setAdapter(new MyFrags(getChildFragmentManager()));
        tl.setupWithViewPager(vp);
        vp.setOffscreenPageLimit(5);
        }

@Override
public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        }

@Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.iv_caidanlist:
        Intent intent=new Intent(getActivity(), ProductActivity.class);
        startActivity(intent);
        break;
        }
        }

 class MyFrags extends FragmentPagerAdapter {
    public MyFrags(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        HomeDataFragment homeDataFragment=new HomeDataFragment();
        return homeDataFragment;
    }

    @Override
    public int getCount() {


        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
}
