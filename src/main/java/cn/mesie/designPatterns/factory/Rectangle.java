package cn.mesie.designPatterns.factory;

/**
 * Created by 2018/10/7 13:43
 * 长方形
 * @author: mesie
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("画长方形的方法");
    }
}
