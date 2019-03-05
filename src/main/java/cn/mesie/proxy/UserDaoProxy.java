package cn.mesie.proxy;

/**
 * Created by 2018/10/2 12:50
 * 代理对象
 * @author: mesie
 */
public class UserDaoProxy implements IUserDao{

    private IUserDao iUserDao;

    public UserDaoProxy(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public void demand(String demandName) {
        iUserDao.demand(demandName);
    }
}
