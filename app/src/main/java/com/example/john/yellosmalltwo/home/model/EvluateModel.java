package com.example.john.yellosmalltwo.home.model;



import com.example.john.yellosmalltwo.bean.RestaurantBean;
import com.example.john.yellosmalltwo.home.presenter.EvluatePresenterImp;
import com.example.john.yellosmalltwo.utils.RetrofitTwoUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by john on 2018/7/13.
 */

public class EvluateModel {
    public void getComment(final EvluatePresenterImp presenterImp){
        RetrofitTwoUtils.getInstance().getRestaurant().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RestaurantBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RestaurantBean bean) {
                    presenterImp.success(bean);
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
