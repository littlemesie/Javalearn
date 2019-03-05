package cn.mesie.proxy;

/**
 * Created by 2018/10/2 14:03
 *
 * @author: mesie
 */
public class CglibClient {

    public static void main(String[] args) {
        //目标对象
        CglibUserDao user = new CglibUserDao();
        user.setName("小明");

        //动态产生一个代理类
        CglibUserDao proxy = (CglibUserDao) new CglibProxyFactory(user).getProxyInstance();

        //通过代理类，执行doSomething方法；
        proxy.demand("产品经理小李");
    }
}
