package com.example.john.yellosmalltwo.home.presenter;


import com.example.john.yellosmalltwo.bean.LoginBean;
import com.example.john.yellosmalltwo.home.model.LoginModel;
import com.example.john.yellosmalltwo.home.view.LoginView;

/**
 * Created by john on 2018/7/10.
 */

public class LoginPresenterImp implements LoginPresenter{
    private LoginView view;
    private LoginModel model;

    public LoginPresenterImp(LoginView view) {
        this.view = view;
        model=new LoginModel();
    }
public void getLogin(String mobile,String password){
        model.getLogin(mobile,password,this);

}
    @Override
    public void loginSuccess(LoginBean bean) {
view.loginSuccess(bean);
    }
}
