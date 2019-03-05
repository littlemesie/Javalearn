package cn.mesie.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 2018/10/4 16:46
 *
 * @author: mesie
 */
public class MyThread02 implements Callable<Integer> {

    //实现call方法
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i < 100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return i;
    }

    public static void main(String[] args) {

        //调用FutureTask类包装的Callable实现类的实例
        FutureTask<Integer> task = new FutureTask<Integer>(new MyThread02());
        new Thread(task,"子线程").start();
        try {
            System.out.println("子线程返回值：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //住线程任务
        for (int i = 1000;i < 1010;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}
