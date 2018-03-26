package com.ct.entity;

import com.alibaba.fastjson.JSONArray;

/**
 * @Author:ct
 * @Date:2018-3-26,17:35
 * @Description:
 */
public class Product {
   public  String productName;
   public  String productPrice;
   public  String productUnit;
   public  String productUnit2;
   public  String productCount;
   public  String productCount2;
   public  String productId;
   public  String remark;
   public JSONArray imgList;

    public Product() {
    }

    public Product(String productName, String productPrice, String productUnit, String productUnit2, String productCount, String productCount2, String productId, String remark, JSONArray imgList) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productUnit = productUnit;
        this.productUnit2 = productUnit2;
        this.productCount = productCount;
        this.productCount2 = productCount2;
        this.productId = productId;
        this.remark = remark;
        this.imgList = imgList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductUnit2() {
        return productUnit2;
    }

    public void setProductUnit2(String productUnit2) {
        this.productUnit2 = productUnit2;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getProductCount2() {
        return productCount2;
    }

    public void setProductCount2(String productCount2) {
        this.productCount2 = productCount2;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public JSONArray getImgList() {
        return imgList;
    }

    public void setImgList(JSONArray imgList) {
        this.imgList = imgList;
    }
}
