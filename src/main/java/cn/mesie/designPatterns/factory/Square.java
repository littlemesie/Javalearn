package cn.mesie.designPatterns.factory;

/**
 * Created by 2018/10/7 13:44
 * 正方形
 * @author: mesie
 */
public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("画正方形的方法");
    }
}
