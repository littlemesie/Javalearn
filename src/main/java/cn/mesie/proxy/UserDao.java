package cn.mesie.proxy;

/**
 * Created by 2018/10/2 12:43
 * 实现接口
 * @author: mesie
 */
public class UserDao implements IUserDao{
    private String name;

    //
    public UserDao(String name){
        this.name = name;
    }

    @Override
    public void demand(String demandName) {
        System.out.println(name + " implemented demand:" + demandName);
    }
}
