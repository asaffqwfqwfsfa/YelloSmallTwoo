package com.example.john.yellosmalltwo.home.presenter;



import com.example.john.yellosmalltwo.bean.UploadBean;
import com.example.john.yellosmalltwo.home.model.UpLoadModel;
import com.example.john.yellosmalltwo.home.view.UpLoadView;

import okhttp3.MultipartBody;

/**
 * Created by john on 2018/7/10.
 */

public class UpLoadPresenterImp implements UpLoadPresenter{
    private UpLoadView view;
    private UpLoadModel model;

    public UpLoadPresenterImp(UpLoadView view) {
        this.view = view;
        model=new UpLoadModel();
    }
    public void upLoad(MultipartBody.Part uid,MultipartBody.Part file){
        model.upLoad(uid,file,this);
    }

    @Override
    public void success(UploadBean bean) {
        view.success(bean);
    }
}
