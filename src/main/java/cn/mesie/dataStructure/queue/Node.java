package cn.mesie.dataStructure.queue;

/**
 * Created by 2019-04-11 00:03
 * 结点类
 * @author: mesie
 */
public class Node<T> {
    Node<T> next;
    T data;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
