package com.example.john.yellosmalltwo.home.presenter;


import com.example.john.yellosmalltwo.bean.HomeBean;
import com.example.john.yellosmalltwo.home.model.HomeModel;
import com.example.john.yellosmalltwo.home.view.HomeView;

/**
 * Created by john on 2018/7/9.
 */

public class HomePresenterImp implements HomePresenter{
    private HomeView view;
    private HomeModel model;

    public HomePresenterImp(HomeView view) {
        this.view = view;
        model=new HomeModel();
    }
public void detach(){
        if (view!=null){
            view=null;
        }
}
public void getHome(){
    model.getHome(this);
}
    @Override
    public void success(HomeBean bean) {
        view.success(bean);
    }
}
