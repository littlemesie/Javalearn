package cn.mesie.base;

/**
 * Created by 2019-04-27 22:55
 *
 * @author: mesie
 */
public class StringTest {

    public static void main(String[] args) {
        //这里的 a 和 b  都是同一个对象，指向同一个字符串常量池对象。
        String a = "123";
        String b = "123";
        //创建了2个对象
        String c = new String("123");
        System.out.println("a=b:" + (a == b));
        System.out.println("a=c:" + (a == c));

        System.out.println("a=" + a);

    }
}
