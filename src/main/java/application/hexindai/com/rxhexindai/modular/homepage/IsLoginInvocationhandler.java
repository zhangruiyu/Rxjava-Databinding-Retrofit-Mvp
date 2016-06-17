package application.hexindai.com.rxhexindai.modular.homepage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import application.hexindai.com.rxhexindai.C;
import application.hexindai.com.rxhexindai.util.HXLog;

/**
 * Created by zhangruiyu on 16/6/7.
 */

public class IsLoginInvocationhandler implements InvocationHandler {
    private Object delegate;

    public  IsLoginInvocationhandler(Object delegate) {
        this.delegate = delegate;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        if (C.USERINFO.islogin) {
            invoke = method.invoke(delegate, args);
        } else {
            HXLog.d("哦哈哈");
        }
        return invoke;
    }
}
