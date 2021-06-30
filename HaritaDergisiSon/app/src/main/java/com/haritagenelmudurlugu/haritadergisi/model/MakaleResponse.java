package com.haritagenelmudurlugu.haritadergisi.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MakaleResponse {


    @SerializedName("makale")
    private  ArrayList<Makale> result;

    public MakaleResponse() {

        this.result = new ArrayList<>();
    }

    public ArrayList<Makale> getResult() {
        return result;
    }
}
