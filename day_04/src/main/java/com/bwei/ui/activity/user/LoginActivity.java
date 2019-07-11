package com.bwei.ui.activity.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.bwei.MainActivity;
import com.bwei.R;
import com.bwei.entity.LogEntity;
import com.bwei.entity.RegEntity;
import com.bwei.mvp.user.UserContract;
import com.bwei.mvp.user.UserPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity implements UserContract.IUserView {

    private Unbinder bind;
    @BindView(R.id.ed_log_reg_phone)
    EditText ed_log_reg_phone;
    @BindView(R.id.ed_log_reg_pwd)
    EditText ed_log_reg_pwd;
    @BindView(R.id.reg_bt)
    Button reg_bt;
    @BindView(R.id.log_bt)
    Button log_bt;
    private UserPresenter userPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bind = ButterKnife.bind(this);
        userPresenter = new UserPresenter(this);
        reg_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = ed_log_reg_phone.getText().toString();
                String pwd = ed_log_reg_pwd.getText().toString();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("phone",phone);
                hashMap.put("pwd",pwd);
                userPresenter.getReg(hashMap);
            }
        });

        log_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = ed_log_reg_phone.getText().toString();
                String pwd = ed_log_reg_pwd.getText().toString();
                HashMap<String, String> logMap = new HashMap<>();
                logMap.put("phone",phone);
                logMap.put("pwd",pwd);
                userPresenter.getLog(logMap);
            }
        });
    }

    @Override
    public void succReg(RegEntity regEntity) {
        String status = regEntity.status;
        if (status.equals("0000")){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void succLog(LogEntity logEntity) {
        SPUtils.getInstance().put("headPic",logEntity.getResult().getHeadPic());
        String status = logEntity.getStatus();
        if (status.equals("0000")){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null){
            bind.unbind();
        }
        userPresenter.onDetch();
    }
}
