package cn.mesie.designPatterns.factory;

/**
 * Created by 2018/10/7 13:39
 *
 * @author: mesie
 */
public class SimpleFactory {

    /**
     * 创建简单工厂
     * @param type
     * @return
     */
    public static Shape createInstance(String type){
        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("circle")){
            return new Circle();
        } else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        } else if(type.equalsIgnoreCase("square")){
            return new Square();
        }
        return null;
    }

    public static void main(String[] args) {
        //获取的对象，并调用它的 draw 方法
        Shape shape = SimpleFactory.createInstance("circle");
        shape.draw();

    }
}
