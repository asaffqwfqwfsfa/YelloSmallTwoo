package com.example.john.yellosmalltwo.utils;




import com.example.john.yellosmalltwo.bean.CatagoryBean;
import com.example.john.yellosmalltwo.bean.HomeBean;
import com.example.john.yellosmalltwo.bean.LoginBean;
import com.example.john.yellosmalltwo.bean.ProductCatagoryBean;
import com.example.john.yellosmalltwo.bean.UploadBean;
import com.example.john.yellosmalltwo.bean.VersionBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by john on 2018/7/5.
 */

public interface ApiService {
    String URL="https://www.zhaoapi.cn/";
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("mobile") String mobile, @Field("password") String password);
    @GET("home/getHome")
    Observable<HomeBean> getHome();
    @POST("file/upload")
    @Multipart
    Observable<UploadBean> uploadFile(@Part MultipartBody.Part uid, @Part MultipartBody.Part file);
    @GET("product/getCatagory")
    Observable<CatagoryBean> getCatagory();
    @POST("product/getProductCatagory")
    @FormUrlEncoded
    Observable<ProductCatagoryBean> getProductCatagory(@Field("cid") String cid);
    @POST("version/getVersion")
    @FormUrlEncoded
    Observable<VersionBean> getVersion(@Field("type") String type);
}
