package com.example.dia;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("diagnose")
    Call<User> performDiagnoses(@Field("pregnancies") String pregnancies,
                                @Field("glucose") String glucose,
                                @Field("bp") String bp,
                                @Field("st") String st,
                                @Field("insulin") String insulin,
                                @Field("bmi") String bmi,
                                @Field("dpf") String dpf,
                                @Field("age") String age);

}
