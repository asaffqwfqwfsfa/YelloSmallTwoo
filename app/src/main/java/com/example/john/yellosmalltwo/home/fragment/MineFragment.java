package com.example.john.yellosmalltwo.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.UploadBean;
import com.example.john.yellosmalltwo.home.activity.EditDataActivity;
import com.example.john.yellosmalltwo.home.activity.SettingsActivity;
import com.example.john.yellosmalltwo.home.presenter.UpLoadPresenterImp;
import com.example.john.yellosmalltwo.home.view.UpLoadView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by john on 2018/7/17.
 */

public class MineFragment extends Fragment implements View.OnClickListener, UpLoadView {
    @BindView(R.id.iv_wode_touxiang)
    ImageView ivWodeTouxiang;
    @BindView(R.id.tv_wode_yonghuming)
    TextView tvWodeYonghuming;
    @BindView(R.id.iv_wode_zhankai)
    ImageView ivWodeZhankai;
    @BindView(R.id.tv_wode_qian)
    TextView tvWodeQian;
    @BindView(R.id.tv_wode_dingdan)
    TextView tvWodeDingdan;
    @BindView(R.id.tv_wode_xiaoxi)
    TextView tvWodeXiaoxi;
    @BindView(R.id.change_news)
    RelativeLayout changeNews;
    @BindView(R.id.like_shop)
    RelativeLayout likeShop;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.cheap_shop)
    RelativeLayout cheapShop;
    @BindView(R.id.idea_tell)
    RelativeLayout ideaTell;
    @BindView(R.id.setting)
    RelativeLayout setting;
    Unbinder unbinder;
    @BindView(R.id.iv_qipao)
    ImageView ivQipao;
    @BindView(R.id.tv_set)
    TextView tvSet;
    private UpLoadPresenterImp presenterImp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        ivWodeTouxiang.setOnClickListener(this);
        changeNews.setOnClickListener(this);
        presenterImp = new UpLoadPresenterImp(this);
        ivQipao.setOnClickListener(this);
        tvSet.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_wode_touxiang:
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/42074.jpg");
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
                MultipartBody.Part partUid = MultipartBody.Part.createFormData("uid", "14509");
                MultipartBody.Part partFile = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
                presenterImp.upLoad(partUid, partFile);
                break;
            case R.id.change_news:
                Intent intent = new Intent(getActivity(), EditDataActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_qipao:

                break;
            case R.id.tv_set:
                Intent intent1=new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent1);
        }
    }

    @Override
    public void success(final UploadBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), bean.getMsg(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}
