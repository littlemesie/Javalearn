package cn.mesie.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by 2018/10/2 13:33
 *
 * @author: mesie
 */
public class DynamicClient {

    public static void main(String[] args) {
        //要代理的真实对象
        IUserDao user = new UserDao("小明");
        //创建中介类实例
        InvocationHandler handler = new ProxyFactory(user);
        //获取类加载器
        ClassLoader cl = user.getClass().getClassLoader();
        //动态产生一个代理类
        IUserDao proxy = (IUserDao) Proxy.newProxyInstance(cl, user.getClass().getInterfaces(), handler);
        //通过代理类，执行doSomething方法；
        proxy.demand("产品经理小李");
    }
}
