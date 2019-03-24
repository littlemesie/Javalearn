package cn.mesie.dataStructure.tree;

/**
 * Created by 2019-03-24 15:56
 * 节点类
 * @author: mesie
 */
public class Node<T> {
    T data;
    //记录器父节点的位置
    int parent;
    public Node(){

    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", parent=" + parent +
                '}';
    }
}
