package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

@SerializedName("IdQuangCao")
@Expose
private String idQuangCao;
@SerializedName("HinhAnhQC")
@Expose
private String hinhAnhQC;
@SerializedName("NoiDungQC")
@Expose
private String noiDungQC;
@SerializedName("IdBaiHat")
@Expose
private String idBaiHat;
@SerializedName("TenBaiHat")
@Expose
private String tenBaiHat;
@SerializedName("HinhBaiHat")
@Expose
private String hinhBaiHat;

public String getIdQuangCao() {
return idQuangCao;
}

public void setIdQuangCao(String idQuangCao) {
this.idQuangCao = idQuangCao;
}

public String getHinhAnhQC() {
return hinhAnhQC;
}

public void setHinhAnhQC(String hinhAnhQC) {
this.hinhAnhQC = hinhAnhQC;
}

public String getNoiDungQC() {
return noiDungQC;
}

public void setNoiDungQC(String noiDungQC) {
this.noiDungQC = noiDungQC;
}

public String getIdBaiHat() {
return idBaiHat;
}

public void setIdBaiHat(String idBaiHat) {
this.idBaiHat = idBaiHat;
}

public String getTenBaiHat() {
return tenBaiHat;
}

public void setTenBaiHat(String tenBaiHat) {
this.tenBaiHat = tenBaiHat;
}

public String getHinhBaiHat() {
return hinhBaiHat;
}

public void setHinhBaiHat(String hinhBaiHat) {
this.hinhBaiHat = hinhBaiHat;
}

}