package com.example.myapplication.Service;

import com.example.myapplication.Model.Album;
import com.example.myapplication.Model.BaiHat;
import com.example.myapplication.Model.ChuDeTheLoai;
import com.example.myapplication.Model.PlayList;
import com.example.myapplication.Model.QuangCao;
import com.example.myapplication.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/// dung de gửi phương thức tới sv roi sau do lay data tu sv ve
public interface DataService {

    @GET("songbanner.php")
    Call<List<QuangCao>> GetDataBanner();
    @GET("playlistfortoday.php")
    Call<List<PlayList>> GetPlayListForToDay();
    @GET("chudevatheloaitoday.php")
    Call<ChuDeTheLoai> GetCategoryToDay();
    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();
    @GET("baihatyeuthich.php")
    Call<List<BaiHat>> GetFavoriteSong();
    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<BaiHat>> GetListSongForBanner(@Field("idquangcao") String idquangcao);
    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<BaiHat>> GetListSongForPlayList(@Field("idplaylist") String idplaylist);
    @FormUrlEncoded
    @POST("listsong.php")
    Call<List<BaiHat>> GetListSongForAlbum(@Field("idplaylist") String idalbum);
    @GET("User.php")
    Call<List<User>> GetDataUser();
    @FormUrlEncoded
    @POST("search.php")
    Call<List<BaiHat>> GetSearchSong(@Field("keyword") String keyword);
    @FormUrlEncoded
    @POST("updatelike.php")
    Call<String> UpdateLike(@Field("luotthich") String luotthich,@Field("idbaihat") String idbaihat);
    @GET("xemthemforplaylist.php")
    Call<List<PlayList>> GetAllPlayList();
}
