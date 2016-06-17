package application.hexindai.com.rxhexindai.modular.homepage;

import java.lang.reflect.Proxy;

/**
 * Created by zhangruiyu on 16/6/7.
 */

public class ProxyFactory {
    public static IsLoginInvocationhandlerInterface getIsLoginInvocationhandlerImpl() {
        IsLoginInvocationhandlerInterface isLoginInvocationhandler = new IsLoginInvocationhandlerImpl();
        IsLoginInvocationhandler handler = new IsLoginInvocationhandler(isLoginInvocationhandler);
      //  IsLoginInvocationhandlerInterface isLoginInvocationhandlerInterface = (IsLoginInvocationhandlerInterface) Proxy.newProxyInstance(IsLoginInvocationhandlerInterface.class.getClassLoader(), new Class[]{IsLoginInvocationhandlerInterface.class
        //}, handler);
        IsLoginInvocationhandlerInterface isLoginInvocationhandlerInterface = (IsLoginInvocationhandlerInterface) Proxy.newProxyInstance(isLoginInvocationhandler.getClass().getClassLoader(), IsLoginInvocationhandlerImpl.class.getInterfaces()
        , handler);
        return isLoginInvocationhandlerInterface;
    }
}
