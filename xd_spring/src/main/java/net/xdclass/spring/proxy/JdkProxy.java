package net.xdclass.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {

        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object ret = null;
        try {
            System.out.println("JDK Proxy " + method.getName() + "before ");
            ret = method.invoke(targetObject, args);
            System.out.println("JDK Proxy " + method.getName() + "after ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
}
