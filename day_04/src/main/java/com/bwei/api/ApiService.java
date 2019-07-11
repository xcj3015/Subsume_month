package com.bwei.api;

import com.bwei.entity.LogEntity;
import com.bwei.entity.RegEntity;
import com.bwei.entity.UpPicEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @POST(Api.REG_URL)
    @FormUrlEncoded
    Observable<RegEntity> reg(@FieldMap HashMap<String,String> hashMap);

    @POST(Api.LOG_URL)
    @FormUrlEncoded
    Observable<LogEntity> log(@FieldMap HashMap<String,String> hashMap);

    @Multipart
    @POST(Api.UP_PIC_URL)
    Observable<UpPicEntity> upPic(@HeaderMap HashMap<String,String> hashMap, @Part MultipartBody.Part filePath);



}
