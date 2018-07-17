package com.example.john.yellosmalltwo.home.presenter;


import com.example.john.yellosmalltwo.bean.OffSetZeroBean;
import com.example.john.yellosmalltwo.home.model.OrderModel;
import com.example.john.yellosmalltwo.home.view.OrderView;

/**
 * Created by john on 2018/7/13.
 */

public class OrderPresenterImp implements OrderPresenter{
    private OrderView view;
    private OrderModel model;

    public OrderPresenterImp(OrderView view) {
        this.view = view;
        model=new OrderModel();
    }
public void getRestaurant(){
        model.getRestaurant(this);
}
    @Override
    public void success(OffSetZeroBean bean) {
view.success(bean);
    }
}
