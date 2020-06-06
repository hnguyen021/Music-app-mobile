package com.example.myapplication.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlayList  implements Serializable {

    @SerializedName("idPlayList")
    @Expose
    private String idPlayList;
    @SerializedName("TenPlayList")
    @Expose
    private String tenPlayList;
    @SerializedName("HinhNen")
    @Expose
    private String hinhNen;
    @SerializedName("IconPlayList")
    @Expose
    private String iconPlayList;

    public String getIdPlayList() {
        return idPlayList;
    }

    public void setIdPlayList(String idPlayList) {
        this.idPlayList = idPlayList;
    }

    public String getTenPlayList() {
        return tenPlayList;
    }

    public void setTenPlayList(String tenPlayList) {
        this.tenPlayList = tenPlayList;
    }

    public String getHinhNen() {
        return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
        this.hinhNen = hinhNen;
    }

    public String getIconPlayList() {
        return iconPlayList;
    }

    public void setIconPlayList(String iconPlayList) {
        this.iconPlayList = iconPlayList;
    }

}