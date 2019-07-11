package com.bwei.mvp.user;

import android.util.Log;

import com.bwei.api.ApiService;
import com.bwei.entity.LogEntity;
import com.bwei.entity.RegEntity;
import com.bwei.net.HttpUtils;
import com.bwei.net.NetCallback;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserModel implements UserContract.IUserModel {
    @Override
    public void doReg(HashMap<String, String> hashMap, NetCallback netCallback) {
        HttpUtils.getHttpUtils().create(ApiService.class)
                .reg(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegEntity>() {
                    @Override
                    public void accept(RegEntity regEntity) throws Exception {
                        netCallback.succReg(regEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("123s",throwable.toString());
                    }
                });
    }

    @Override
    public void doLog(HashMap<String, String> hashMap, NetCallback netCallback) {
        HttpUtils.getHttpUtils().create(ApiService.class)
                .log(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LogEntity>() {
                    @Override
                    public void accept(LogEntity logEntity) throws Exception {
                        netCallback.succLog(logEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("123s",throwable.toString());
                    }
                });
    }
}
