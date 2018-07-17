package com.example.john.yellosmalltwo.home.model;



import com.example.john.yellosmalltwo.bean.VersionBean;
import com.example.john.yellosmalltwo.home.presenter.VersionPresenterImp;
import com.example.john.yellosmalltwo.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by john on 2018/7/12.
 */

public class VersionModel {
    public void getVersion(String type, final VersionPresenterImp versionPresenterImp){
        RetrofitUtils.getInstance().getVersion(type).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VersionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VersionBean bean) {
versionPresenterImp.success(bean);
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
