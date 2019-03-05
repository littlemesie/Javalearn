package cn.mesie.designPatterns.factory;

/**
 * Created by 2018/10/7 13:45
 * 圆形
 * @author: mesie
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("画圆形的方法");
    }
}
