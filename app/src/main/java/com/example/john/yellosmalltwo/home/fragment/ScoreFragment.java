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
import com.example.john.yellosmalltwo.bean.CommentBean;
import com.example.john.yellosmalltwo.home.adapter.ScoreRvAdapter;
import com.example.john.yellosmalltwo.home.presenter.CommentPresenterImp;
import com.example.john.yellosmalltwo.home.view.CommentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/7/17.
 */

public class ScoreFragment extends Fragment implements CommentView {
    @BindView(R.id.rv_score)
    RecyclerView rvScore;
    Unbinder unbinder;
    private CommentPresenterImp presenterImp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        presenterImp = new CommentPresenterImp(this);
        presenterImp.getComment();
        rvScore.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        rvScore.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(final CommentBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<CommentBean.DataBean> list = bean.getData();
                ScoreRvAdapter rvAdapter=new ScoreRvAdapter(list,getActivity());
                rvScore.setAdapter(rvAdapter);
            }
        });
    }
}
