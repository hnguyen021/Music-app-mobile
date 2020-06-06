package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("idUser")
    @Expose
    private String idUser;
    @SerializedName("TenUser")
    @Expose
    private String tenUser;
    @SerializedName("PassWord")
    @Expose
    private String passWord;
    @SerializedName("idBaiHat")
    @Expose
    private String idBaiHat;
    @SerializedName("idComMent")
    @Expose
    private String idComMent;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(String idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public String getIdComMent() {
        return idComMent;
    }

    public void setIdComMent(String idComMent) {
        this.idComMent = idComMent;
    }

}