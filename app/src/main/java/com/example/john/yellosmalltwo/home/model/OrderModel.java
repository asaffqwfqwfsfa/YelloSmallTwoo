package com.example.john.yellosmalltwo.home.model;



import com.example.john.yellosmalltwo.bean.OffSetZeroBean;
import com.example.john.yellosmalltwo.home.presenter.OrderPresenterImp;
import com.example.john.yellosmalltwo.utils.RetrofitThreeUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by john on 2018/7/13.
 */

public class OrderModel {
    public void getRestaurant(final OrderPresenterImp presenterImp){
        RetrofitThreeUtils.getInstance().getZero().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OffSetZeroBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OffSetZeroBean bean) {
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
