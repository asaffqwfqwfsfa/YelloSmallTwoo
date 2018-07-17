package com.example.john.yellosmalltwo.home.model;



import com.example.john.yellosmalltwo.bean.UploadBean;
import com.example.john.yellosmalltwo.home.presenter.UpLoadPresenterImp;
import com.example.john.yellosmalltwo.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by john on 2018/7/10.
 */

public class UpLoadModel {
    public void upLoad(MultipartBody.Part uid, MultipartBody.Part file, final UpLoadPresenterImp presenterImp){
        RetrofitUtils.getInstance().uploadFile(uid,file).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UploadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UploadBean bean) {
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
