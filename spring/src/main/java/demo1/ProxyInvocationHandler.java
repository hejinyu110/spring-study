package demo1;

import demo.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理 ，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    //获取反射对象 代理类
    public Object getProxy(){
        //当前类的反射，代理对象的反射，当前类
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());//再动态代理层实现给每个方法加上日志，而不用更改实现类
        //动态代理的本质，就是使用反射机制实现
        Object result = method.invoke(target,args);
        return result;
    }

    public void log(String method){
        System.out.println("执行了"+method+"方法");
    }
}
