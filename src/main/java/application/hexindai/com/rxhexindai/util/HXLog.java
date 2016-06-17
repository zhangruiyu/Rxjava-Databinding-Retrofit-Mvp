package application.hexindai.com.rxhexindai.util;

import com.orhanobut.logger.Logger;

/**
 * Created by zhangruiyu on 16/5/30.
 */

public class HXLog {
    public static void d(String message) {
        Logger.d(message);
    }

    public static void e(Throwable e) {
        Logger.e(e.getMessage());
    }
}
