package com.example.john.yellosmalltwo.utils;

import com.example.john.yellosmalltwo.bean.CommentBean;
import com.example.john.yellosmalltwo.bean.RestaurantBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by john on 2018/7/17.
 */

public interface Constans {
    String TWO_URL="http://39.108.3.12:3000/v1/";
    @GET("restaurant/32")
    Observable<RestaurantBean> getRestaurant();
    @GET("comment?restaurant_id=32&offset=0&limit=5")
    Observable<CommentBean> getComment();
}
