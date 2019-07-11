package com.bwei.net;

import com.bwei.entity.LogEntity;
import com.bwei.entity.RegEntity;
import com.bwei.entity.UpPicEntity;

public interface NetCallback {

    void succReg(RegEntity regEntity);
    void succLog(LogEntity logEntity);
    void succUpPic(UpPicEntity upPicEntity);

}
