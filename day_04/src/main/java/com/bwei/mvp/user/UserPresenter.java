package com.bwei.mvp.user;

import com.bwei.entity.LogEntity;
import com.bwei.entity.RegEntity;
import com.bwei.entity.UpPicEntity;
import com.bwei.net.NetCallback;

import java.util.HashMap;

public class UserPresenter implements UserContract.IUserPresenter {
    UserContract.IUserView userView;
    UserModel userModel;
    public UserPresenter(UserContract.IUserView userView){
        this.userView = userView;
        userModel = new UserModel();
    }

    @Override
    public void getReg(HashMap<String, String> hashMap) {
        userModel.doReg(hashMap, new NetCallback() {
            @Override
            public void succReg(RegEntity regEntity) {
                userView.succReg(regEntity);
            }

            @Override
            public void succLog(LogEntity logEntity) {

            }

            @Override
            public void succUpPic(UpPicEntity upPicEntity) {

            }
        });
    }

    @Override
    public void getLog(HashMap<String, String> hashMap) {
        userModel.doLog(hashMap, new NetCallback() {
            @Override
            public void succReg(RegEntity regEntity) {

            }

            @Override
            public void succLog(LogEntity logEntity) {
                userView.succLog(logEntity);
            }

            @Override
            public void succUpPic(UpPicEntity upPicEntity) {

            }
        });
    }

    public void onDetch(){
        if (userModel != null){
            userModel = null;
        }
        if (userView != null){
            userView = null;
        }
        System.gc();
    }
}
