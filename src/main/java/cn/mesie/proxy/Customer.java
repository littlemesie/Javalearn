package cn.mesie.proxy;

/**
 * Created by 2018/10/2 12:58
 *
 * @author: mesie
 */
public class Customer {

    public static void main(String[] args) {
        //产品经理
        String name = "小 李";
        //目标对象 定义一个java码农
        IUserDao user = new UserDao("小 明");
        //代理对象 定义一个产品经理
        IUserDao proxy = new UserDaoProxy(user);
        //让产品经理实现一个需求
        proxy.demand(name);
    }
}
