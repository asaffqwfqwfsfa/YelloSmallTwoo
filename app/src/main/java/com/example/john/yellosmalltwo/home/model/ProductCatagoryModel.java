package com.example.john.yellosmalltwo.home.model;


import com.example.john.yellosmalltwo.bean.ProductCatagoryBean;
import com.example.john.yellosmalltwo.home.presenter.ProductCatagoryPresenterImp;
import com.example.john.yellosmalltwo.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by john on 2018/7/10.
 */

public class ProductCatagoryModel {
    public void getProductCatagory(String cid, final ProductCatagoryPresenterImp productCatagoryPresenterImp){
        RetrofitUtils.getInstance().getProductCatagory(cid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductCatagoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductCatagoryBean bean) {
                        List<ProductCatagoryBean.DataBean> data = bean.getData();
                        productCatagoryPresenterImp.productCatagorySuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
