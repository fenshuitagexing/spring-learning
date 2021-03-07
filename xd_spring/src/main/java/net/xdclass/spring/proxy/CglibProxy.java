package net.xdclass.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {

        // 注入目标类
        this.targetObject = targetObject;

        // 设置代理类的父类为目标类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObject.getClass());
        enhancer.setCallback(this);

        // 创建子类（代理对象）
        return enhancer.create();
    }

    @Override
    //public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        Object result = null;
        try {
            System.out.println("CGLIB Proxy " + method.getName() + "before ");
            methodProxy.invokeSuper(o, args);
            System.out.println("CGLIB Proxy " + method.getName() + "before ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
