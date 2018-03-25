package com.ct.entity;

import java.io.Serializable;

public class User implements Serializable{

    public String account;
    public String mima;
    public String name;
    public String phone;

    public User() {
    }

    public User(String account, String mima, String name, String phone) {
        this.account = account;
        this.mima = mima;
        this.name = name;
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
