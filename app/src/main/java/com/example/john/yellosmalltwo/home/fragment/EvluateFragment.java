package com.example.john.yellosmalltwo.home.fragment;

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
import android.widget.TextView;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.RestaurantBean;
import com.example.john.yellosmalltwo.home.view.EvaluateView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/7/17.
 */

public class EvluateFragment extends Fragment implements EvaluateView {

    @BindView(R.id.tl_evluate)
    TabLayout tlEvluate;
    @BindView(R.id.vp_evluate)
    ViewPager vpEvluate;
    Unbinder unbinder;
    @BindView(R.id.sdv_evluate)
    SimpleDraweeView sdvEvluate;
    @BindView(R.id.tv_yueshou_evluate)
    TextView tvYueshouEvluate;
    @BindView(R.id.tv_score_evluate)
    TextView tvScoreEvluate;
    @BindView(R.id.tv_lijian_evluate)
    TextView tvLijianEvluate;
    @BindView(R.id.tv_man_evluate)
    TextView tvManEvluate;
    private List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evluate, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        list.add("菜单");
        list.add("评价");
        list.add("商家");
        vpEvluate.setAdapter(new MyFrags(getChildFragmentManager()));
        tlEvluate.setupWithViewPager(vpEvluate);
        vpEvluate.setOffscreenPageLimit(3);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(final RestaurantBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RestaurantBean.DataBean data = bean.getData();
                sdvEvluate.setImageURI(data.getPic_url());
                tvYueshouEvluate.setText(data.getMonth_sales_tip());
                tvScoreEvluate.setText("评价"+data.getQuality_score());
                for (int i = 0; i < data.getDiscounts2().size(); i++) {
                    tvLijianEvluate.setText(data.getDiscounts2().get(i).getInfo());
                }


            }
        });
    }

    class MyFrags extends FragmentPagerAdapter {
        Fragment fragment = null;

        public MyFrags(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    break;
                case 1:
                    fragment=new ScoreFragment();
                    break;
                case 2:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {


            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }


}
