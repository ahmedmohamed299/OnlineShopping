package com.example.hp.onlineshopping.Model;

import com.example.hp.onlineshopping.Model.DataModel.GetActivate;
import com.example.hp.onlineshopping.Model.DataModel.GetCategories;
import com.example.hp.onlineshopping.Model.DataModel.GetHome;
import com.example.hp.onlineshopping.Model.DataModel.GetRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIs {

    @FormUrlEncoded
    @POST("user/register")
    Call<GetRegister>getRegister (@Field("mobile_number")String mobile_number,
                                  @Field("device_token")String device_token,
                                  @Field("name")String name);

    @FormUrlEncoded
    @POST("user/activateAccount")
    Call<GetActivate>getactivate(@Header("Token") String Token, @Header("Lang") String Lang, @Field("activation_code") String activation_code);

    @POST("products/categories")
    Call<GetCategories>getCategories(@Header("Lang") String Lang);

    @POST("home")
    Call<GetHome>getHome(@Header("Lang") String Lang);
}
