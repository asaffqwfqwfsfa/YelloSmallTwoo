package com.example.john.yellosmalltwo.home.presenter;


import com.example.john.yellosmalltwo.bean.CatagoryBean;
import com.example.john.yellosmalltwo.home.model.CatagoryModel;
import com.example.john.yellosmalltwo.home.view.CatagoryView;

/**
 * Created by john on 2018/7/10.
 */

public class CatagoryPresenterImp implements CatagoryPresenter{
    private CatagoryView view;
    private CatagoryModel model;

    public CatagoryPresenterImp(CatagoryView view) {
        this.view = view;
        model=new CatagoryModel();
    }
public void getCatagory(){
        model.getCatagory(this);
}
    @Override
    public void catagorySuccess(CatagoryBean bean) {
    view.catagorySuccess(bean);
    }
}
