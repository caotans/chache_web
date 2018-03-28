package com.ct.entity;

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

/**
 * @Author:ct
 * @Date:2018-3-26,17:35
 * @Description:
 */
public class Product implements Serializable{
   public  String productName;
   public  String productPrice;
   public  String productCurrency;
   public  String productPrice2;
   public  String productCurrency2;
   public  String productPrice3;
   public  String productCurrency3;
   public  String productUnit;
   public  String productUnit2;
   public  String productCount;
   public  String productCount2;
   public  String productId;
   public  String remark;
   public JSONArray imgList;
    public  String classifyType;
    public  String classifyName;

    public Product() {
    }

    public Product(String productName, String productPrice, String productCurrency, String productPrice2, String productCurrency2, String productPrice3, String productCurrency3, String productUnit, String productUnit2, String productCount, String productCount2, String productId, String remark, JSONArray imgList, String classifyType, String classifyName) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCurrency = productCurrency;
        this.productPrice2 = productPrice2;
        this.productCurrency2 = productCurrency2;
        this.productPrice3 = productPrice3;
        this.productCurrency3 = productCurrency3;
        this.productUnit = productUnit;
        this.productUnit2 = productUnit2;
        this.productCount = productCount;
        this.productCount2 = productCount2;
        this.productId = productId;
        this.remark = remark;
        this.imgList = imgList;
        this.classifyType = classifyType;
        this.classifyName = classifyName;
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

    public String getProductCurrency() {
        return productCurrency;
    }

    public void setProductCurrency(String productCurrency) {
        this.productCurrency = productCurrency;
    }

    public String getProductPrice2() {
        return productPrice2;
    }

    public void setProductPrice2(String productPrice2) {
        this.productPrice2 = productPrice2;
    }

    public String getProductCurrency2() {
        return productCurrency2;
    }

    public void setProductCurrency2(String productCurrency2) {
        this.productCurrency2 = productCurrency2;
    }

    public String getProductPrice3() {
        return productPrice3;
    }

    public void setProductPrice3(String productPrice3) {
        this.productPrice3 = productPrice3;
    }

    public String getProductCurrency3() {
        return productCurrency3;
    }

    public void setProductCurrency3(String productCurrency3) {
        this.productCurrency3 = productCurrency3;
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

    public String getClassifyType() {
        return classifyType;
    }

    public void setClassifyType(String classifyType) {
        this.classifyType = classifyType;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }
}
