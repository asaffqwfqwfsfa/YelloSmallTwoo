package com.example.john.yellosmalltwo.home.presenter;



import com.example.john.yellosmalltwo.bean.ProductCatagoryBean;
import com.example.john.yellosmalltwo.home.model.ProductCatagoryModel;
import com.example.john.yellosmalltwo.home.view.ProductCatagoryView;

import java.util.List;

/**
 * Created by john on 2018/7/10.
 */

public class ProductCatagoryPresenterImp implements ProductCatagoryPresenter{
    private ProductCatagoryView view;
    private ProductCatagoryModel model;

    public ProductCatagoryPresenterImp(ProductCatagoryView view) {
        this.view = view;
        model=new ProductCatagoryModel();
    }
public void getProductCatagory(String cid){
        model.getProductCatagory(cid,this);
}
    @Override
    public void productCatagorySuccess(List<ProductCatagoryBean.DataBean> childList) {
view.productCatagorySuccess(childList);
    }
}
