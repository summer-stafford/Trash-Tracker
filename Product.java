package com.example.summerstafford.trashapplication;

public class Product {
    public String productName;
    public String company;
    public int imgId;
    public String url;

    public Product(String pN, String sI, int iI, String url){
        this.productName = pN;
        this.company = sI;
        this.imgId = iI;
        this.url = url;
    }
}
