package com.tuanshang.sourcedemo.presenter;

import android.content.Context;

import com.tuanshang.sourcedemo.bean.BaseResponseBean;
import com.tuanshang.sourcedemo.http.Api;
import com.tuanshang.sourcedemo.http.RetrofitHelper;
import com.tuanshang.sourcedemo.http.RetrofitService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mainpresenter {
    private Context context;
    private RetrofitService retrofitService;

    public Mainpresenter(Context context) {
        this.context = context;
        retrofitService=RetrofitHelper.getRetrofit();


    }

    public void getCode(String type, String phone) {
        Call<BaseResponseBean> call = retrofitService.getCode(type, phone);
        call.enqueue(new Callback<BaseResponseBean>() {
            @Override
            public void onResponse(Call<BaseResponseBean> call, Response<BaseResponseBean> response) {
                response.code();
            }

            @Override
            public void onFailure(Call<BaseResponseBean> call, Throwable t) {
                t.toString();
            }
        });

        //同步
//        try {
//            call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
