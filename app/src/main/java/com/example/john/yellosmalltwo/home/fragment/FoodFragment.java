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

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.CatagoryBean;
import com.example.john.yellosmalltwo.bean.ProductCatagoryBean;
import com.example.john.yellosmalltwo.home.adapter.RvLeftAdapter;
import com.example.john.yellosmalltwo.home.adapter.RvRightAdapter;
import com.example.john.yellosmalltwo.home.presenter.CatagoryPresenterImp;
import com.example.john.yellosmalltwo.home.presenter.ProductCatagoryPresenterImp;
import com.example.john.yellosmalltwo.home.view.CatagoryView;
import com.example.john.yellosmalltwo.home.view.OnItemClickListener;
import com.example.john.yellosmalltwo.home.view.ProductCatagoryView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/7/17.
 */

public class FoodFragment extends Fragment implements CatagoryView,ProductCatagoryView {
    @BindView(R.id.rvleft)
    RecyclerView rvleft;
    @BindView(R.id.rvright)
    RecyclerView rvright;
    Unbinder unbinder;
    private CatagoryPresenterImp catagoryPresenterImp;
    private ProductCatagoryPresenterImp productCatagoryPresenterImp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        catagoryPresenterImp = new CatagoryPresenterImp(this);
        productCatagoryPresenterImp = new ProductCatagoryPresenterImp(this);
        catagoryPresenterImp.getCatagory();
        rvleft.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        rvleft.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rvright.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        rvright.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void catagorySuccess(final CatagoryBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final List<CatagoryBean.DataBean> data = bean.getData();
                final RvLeftAdapter adapter = new RvLeftAdapter(data,getActivity());
                rvleft.setAdapter(adapter);
                productCatagoryPresenterImp.getProductCatagory(data.get(0).getCid() + "");

                adapter.changeCheck(0, true);

                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        adapter.changeCheck(position, true);
                        productCatagoryPresenterImp.getProductCatagory(data.get(position).getCid() + "");
                    }

                    @Override
                    public void onLongClick(int position) {

                    }


                });
            }
        });
    }

    @Override
    public void productCatagorySuccess(final List<ProductCatagoryBean.DataBean> bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < bean.size(); i++) {
                    List<ProductCatagoryBean.DataBean.ListBean> list = bean.get(i).getList();
                    RvRightAdapter rvRightAdapter=new RvRightAdapter(list,getActivity());
                    rvright.setAdapter(rvRightAdapter);
                }
            }
        });
    }
}
