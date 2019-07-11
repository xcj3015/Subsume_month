package com.bwei.mvp.user;

import com.bwei.entity.LogEntity;
import com.bwei.entity.RegEntity;
import com.bwei.net.NetCallback;

import java.util.HashMap;

public interface UserContract {

    interface IUserView{
        void succReg(RegEntity regEntity);
        void succLog(LogEntity logEntity);
    }

    interface IUserModel{
        void doReg(HashMap<String,String> hashMap, NetCallback netCallback);
        void doLog(HashMap<String,String> hashMap,NetCallback netCallback);
    }

    interface IUserPresenter{
        void getReg(HashMap<String,String> hashMap);
        void getLog(HashMap<String,String> hashMap);
    }

}
