package com.codyy.lib.utils.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.codyy.lib.crash.CrashMail;
import com.codyy.lib.crash.MailUtils;
import com.codyy.lib.utils.ConvertUtils;
import com.codyy.lib.utils.EmulatorUtils;
import com.codyy.lib.utils.EncryptUtils;
import com.codyy.lib.utils.LogUtils;
import com.codyy.lib.utils.ToastUtil;
import com.codyy.lib.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.init(this);
//        LogUtils.e("lzw", EncryptUtils.encryptMD5ToString("LZW").toLowerCase());
        TextView textView= (TextView) findViewById(R.id.tv_log);
        textView.setText(EmulatorUtils.getDeviceListing());
//        ToastUtil.show("无法打开此类型文件,请在应用市场下载!");
        ToastUtil.show("无法打开此类型文件,请在应用市场下载!2");
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show();
//        ToastUtil.show("无法打开此类型文件,请在应用市场下载!32");
       /* if (EmulatorUtils.isEmulator()) {
            ToastUtil.show("模拟器");
        } else {
            ToastUtil.show("真机");
        }*/

//       new ThreadTest().start();

//        EmulatorUtils.logcat();
//        ToastUtil.show("无法打开此类型文件,请在应用市场下载!");
    }
     private class ThreadTest extends Thread {
        /**
         * 重写（Override）run()方法 JVM会自动调用该方法
         */
        @Override
        public void run() {
            try {
                MailUtils.sendMail(new CrashMail("mail.codyy.cn", "是否模拟器", EmulatorUtils.getDeviceListing(), "android@codyy.com", "运营平台2.2.0", "android", "lijian@codyy.com", "李健"));
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.e("Exception",e.getMessage());
            }
        }
    }
}
