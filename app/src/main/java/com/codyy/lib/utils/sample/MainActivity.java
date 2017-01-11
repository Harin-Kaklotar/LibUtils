package com.codyy.lib.utils.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codyy.lib.utils.EmulatorUtils;
import com.codyy.lib.utils.ToastUtil;
import com.codyy.lib.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.init(this);
        if(EmulatorUtils.isEmulator()){
            ToastUtil.show("模拟器");
        }else{
            ToastUtil.show("真机");
        }
        EmulatorUtils.logcat();
//        ToastUtil.show("无法打开此类型文件,请在应用市场下载!");
    }
}
