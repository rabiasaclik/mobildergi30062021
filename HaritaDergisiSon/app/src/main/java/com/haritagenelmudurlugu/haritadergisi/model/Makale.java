package com.haritagenelmudurlugu.haritadergisi.model;

import com.google.gson.annotations.SerializedName;

public class Makale {

    @SerializedName("ad")
    private  String Name;

    @SerializedName("yil")
    private  String Year;

    @SerializedName("sayi")
    private  int Number;

    @SerializedName("yazar")
    private  String Author;

    @SerializedName("link")
    private  String Link;

    @SerializedName("fullText")
    private  String FullText;


    public String getName() {
        return Name;
    }

    public String getYear() {
        return Year;
    }

    public int getNumber() {
        return Number;
    }

    public String getAuthor() {
        return Author;
    }

    public String getLink() {
        return Link;
    }

    public String getFullText() {
        return FullText;
    }
}
