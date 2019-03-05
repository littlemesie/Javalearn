package cn.mesie.designPatterns;

/**
 * Created by 2018/10/7 13:24
 * 单例模式
 * @author: mesie
 */
public class SingletonPattern {

    private static SingletonPattern instance;
    private SingletonPattern(){

    }
    public static SingletonPattern getInstance(){
        if(instance==null){
            instance=new SingletonPattern();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        //获取单例对象
        SingletonPattern sp = SingletonPattern.getInstance();
        sp.showMessage();
    }
}
