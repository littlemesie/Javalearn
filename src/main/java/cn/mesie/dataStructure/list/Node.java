package cn.mesie.dataStructure.list;

/**
 * Created by 2019-03-24 13:45
 * 结点类
 * @author: mesie
 */
public class Node<T> {
    /**新元素与链表结合节点**/
    Node<T> next;
    /**新元素数据**/
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
