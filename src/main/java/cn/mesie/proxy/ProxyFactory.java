package cn.mesie.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 2018/10/2 13:27
 *
 * @author: mesie
 */
public class ProxyFactory implements InvocationHandler {

    //被代理的对象
    private IUserDao iUser;

    public ProxyFactory(IUserDao user) {
        this.iUser = user;
    }

    //调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(iUser, args);
        System.out.println(System.currentTimeMillis());
        return result;
    }
}
