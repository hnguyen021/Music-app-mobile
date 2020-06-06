package com.example.myapplication.Service;

public class APIservice {
    //private static String base_url ="http://10.35.18.79:8888123////127.0.0.1";
    private static String base_url ="http://192.168.1.116:8888/";
    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
