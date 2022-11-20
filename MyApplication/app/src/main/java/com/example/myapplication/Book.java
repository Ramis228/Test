package com.example.myapplication;

public class Book {
    public String imgUrl, razdel;
    public double shiran,dolgota;

    public Book() {
    }

    public Book(String imgUrl, String razdel,double shiran,double dolgota) {
        this.imgUrl = imgUrl;
        this.razdel = razdel;
        this.shiran = shiran;
        this.dolgota = dolgota;
    }
}
