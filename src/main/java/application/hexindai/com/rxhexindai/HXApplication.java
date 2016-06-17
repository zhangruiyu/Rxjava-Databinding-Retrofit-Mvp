package application.hexindai.com.rxhexindai;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

/**
 * Created by zhangruiyu on 16/5/20.
 */
public class HXApplication extends Application {
    private static Context application;
    private static HXApplication hxApplication;
    public static HXApplication getApplication() {
        return hxApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        hxApplication = this;
        Logger.init("HXDLOGGER");
    }
}
