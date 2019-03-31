package cn.mesie.thread.base;

/**
 * Created by 2018/10/4 16:39
 *
 * @author: mesie
 */
public class MyThread01 implements Runnable {

    //重写run方法
    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        //创建线程
        Thread mt = new Thread(new MyThread01());
        //启动线程
        mt.start();
        //主线程任务
        for (int i = 1000;i < 1010;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
