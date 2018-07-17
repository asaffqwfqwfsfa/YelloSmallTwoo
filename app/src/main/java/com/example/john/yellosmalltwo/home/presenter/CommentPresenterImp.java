package com.example.john.yellosmalltwo.home.presenter;


import com.example.john.yellosmalltwo.bean.CommentBean;
import com.example.john.yellosmalltwo.home.model.CommentModel;
import com.example.john.yellosmalltwo.home.view.CommentView;

/**
 * Created by john on 2018/7/14.
 */

public class CommentPresenterImp implements CommentPresenter{
    private CommentView view;
    private CommentModel model;

    public CommentPresenterImp(CommentView view) {
        this.view = view;
        model=new CommentModel();
    }
public void getComment(){
        model.getComment(this);
}
    @Override
    public void success(CommentBean bean) {
view.success(bean);
    }
}
