package com.example.john.yellosmalltwo.home.model;



import com.example.john.yellosmalltwo.bean.CommentBean;
import com.example.john.yellosmalltwo.home.presenter.CommentPresenterImp;
import com.example.john.yellosmalltwo.utils.RetrofitTwoUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by john on 2018/7/14.
 */

public class CommentModel {
    public void getComment(final CommentPresenterImp presenterImp){
        RetrofitTwoUtils.getInstance().getComment().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommentBean bean) {
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
