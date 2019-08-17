package com.tuanshang.sourcedemo.http;

import android.database.Observable;


import com.tuanshang.sourcedemo.bean.BaseResponseBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {
    //获取验证码
    @FormUrlEncoded
    @POST("code/index")
    Call<BaseResponseBean> getCode(@Field("type") String type, @Field("phone") String phone);
}
