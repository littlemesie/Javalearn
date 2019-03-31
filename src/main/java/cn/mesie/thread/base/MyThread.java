package cn.mesie.thread.base;

/**
 * Created by 2018/10/4 16:29
 *
 * @author: mesie
 */
public class MyThread extends Thread {

    // 重写run方法
    @Override
    public void run() {
        for(int i = 0;i < 100;i++){
            System.out.println(this.getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        //创建线程
        MyThread mt = new MyThread();
        MyThread mt1 = new MyThread();
        //启动线程
        mt.start();
        mt1.start();
        //主线程任务
        for (int i = 1000;i < 1010;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
