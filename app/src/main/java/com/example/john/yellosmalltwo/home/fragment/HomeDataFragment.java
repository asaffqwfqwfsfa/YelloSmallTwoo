package com.example.john.yellosmalltwo.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.yellosmalltwo.R;
import com.example.john.yellosmalltwo.bean.HomeBean;
import com.example.john.yellosmalltwo.home.adapter.HomeRvAdapter;
import com.example.john.yellosmalltwo.home.presenter.HomePresenterImp;
import com.example.john.yellosmalltwo.home.view.HomeView;
import com.example.john.yellosmalltwo.home.view.OnItemClickListener;
import com.example.john.yellosmalltwo.utils.FrescoImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by john on 2018/7/17.
 */

public class HomeDataFragment extends Fragment implements HomeView {
    @BindView(R.id.bn)
    Banner bn;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private HomePresenterImp presenterImp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_homedata, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        presenterImp = new HomePresenterImp(this);
        presenterImp.getHome();
        bn.setImageLoader(new FrescoImageLoader());
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    @Override
    public void onStop() {
        super.onStop();
        bn.stopAutoPlay();
    }
    @Override
    public void success(final HomeBean bean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<HomeBean.DataBean.BannerBean> banner = bean.getData().getBanner();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < banner.size(); i++) {
                    list.add(banner.get(i).getIcon());
                }
                bn.setImages(list);
                bn.start();
                final HomeBean.DataBean.TuijianBean tuijian = bean.getData().getTuijian();
                final List<HomeBean.DataBean.TuijianBean.ListBeanX> tuijianList = tuijian.getList();
                HomeRvAdapter rvAdapter=new HomeRvAdapter(tuijianList,getActivity());
                rv.setAdapter(rvAdapter);
                rvAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
//                        PopupWindow popupWindow = new PopupWindow();
//                        View view=View.inflate(getActivity(),R.layout.pop_menu,rv);
//                        popupWindow.setContentView(view);
//                        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//                        popupWindow.showAtLocation(view, position,150 , 200);
//
//
//                        SimpleDraweeView sdvPop = view.findViewById(R.id.sdv_pop);
//                        TextView tv1Pop=view.findViewById(R.id.tv1_pop);
//                        TextView tv2Pop=view.findViewById(R.id.tv2_pop);
//                        String s = tuijianList.get(position).getImages().split("\\|")[0];
//                        sdvPop.setImageURI(s);
//                        tv1Pop.setText(tuijianList.get(position).getTitle());
//                        tv2Pop.setText("￥"+tuijianList.get(position).getPrice());

                    }
                    @Override
                    public void onLongClick(int position) {

                    }
                });
            }
        });
    }
}
