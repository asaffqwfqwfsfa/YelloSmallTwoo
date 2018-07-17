package com.example.john.yellosmalltwo.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.OffSetZeroBean;
import com.example.john.yellosmalltwo.home.adapter.OrderRvAdapter;
import com.example.john.yellosmalltwo.home.presenter.OrderPresenterImp;
import com.example.john.yellosmalltwo.home.view.OrderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/7/17.
 */

public class OrderFragment extends Fragment implements OrderView {
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.rv_order)
    RecyclerView rvOrder;
    Unbinder unbinder;
    private OrderPresenterImp presenterImp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        presenterImp = new OrderPresenterImp(this);
        presenterImp.getRestaurant();
        rvOrder.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
rvOrder.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(final OffSetZeroBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<OffSetZeroBean.DataBean> list = bean.getData();
                OrderRvAdapter rvAdapter=new OrderRvAdapter(list,getActivity());
                rvOrder.setAdapter(rvAdapter);
            }
        });
    }
}
