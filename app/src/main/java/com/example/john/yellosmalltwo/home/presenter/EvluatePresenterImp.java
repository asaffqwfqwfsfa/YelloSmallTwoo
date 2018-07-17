package com.example.john.yellosmalltwo.home.presenter;


import com.example.john.yellosmalltwo.bean.RestaurantBean;
import com.example.john.yellosmalltwo.home.model.EvluateModel;
import com.example.john.yellosmalltwo.home.view.EvaluateView;

/**
 * Created by john on 2018/7/13.
 */

public class EvluatePresenterImp implements EvluatePresenter{
    private EvaluateView view;
    private EvluateModel model;

    public EvluatePresenterImp(EvaluateView view) {
        this.view = view;
        model=new EvluateModel();
    }
public void getComment(){
        model.getComment(this);
}
    @Override
    public void success(RestaurantBean bean) {
        view.success(bean);
    }
}
