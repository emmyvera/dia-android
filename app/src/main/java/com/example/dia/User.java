package com.example.dia;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("prediction")
    private String result;

    @SerializedName("probability")
    private String likelihood;

    @SerializedName("bp")
    private String bp;

    @SerializedName("bpNo")
    private int bpNo;

    @SerializedName("bmi")
    private String bmi;

    @SerializedName("bmiNo")
    private int bmiNo;

    public String getResult() {
        return result;
    }

    public String getLikelihood() {
        return likelihood;
    }

    public String getBp() {
        return bp;
    }

    public String getBmi() {
        return bmi;
    }

    public int getBpNo() {
        return bpNo;
    }

    public int getBmiNo() {
        return bmiNo;
    }
}
