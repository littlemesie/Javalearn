package cn.mesie.proxy;

/**
 * Created by 2018/10/2 14:14
 *
 * @author: mesie
 */
public class CglibUserDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void demand(String demandName) {
        System.out.println(name + " implemented demand:" + demandName);
    }
}
