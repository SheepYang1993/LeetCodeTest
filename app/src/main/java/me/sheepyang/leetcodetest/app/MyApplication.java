package me.sheepyang.leetcodetest.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import me.sheepyang.leetcodetest.util.CrashUtils;
import me.sheepyang.leetcodetest.util.LogUtils;

/**
 * Created by Administrator on 2016-12-12.
 */

public class MyApplication extends Application {

    private static MyApplication mInstance;

    public static MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 内存泄露检查工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        mInstance = this;
        CrashUtils.getInstance().init(this);
        LogUtils.getBuilder(this).setTag("SheepYang").setLog2FileSwitch(true).create();
    }
}
