package cn.mesie.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2018/10/10 20:40
 * 实现一棵树
 * @author: mesie
 */
public class TreeParent<E> {

    private final int DEFAULT_TREE_SIZE = 100;
    private int treeSize = 0;
    //使用一个Node数组来记录该树里的所有节点
    private Node<E>[] nodes;
    //记录节点数
    private int nodeNums;
    //以指定根节点创建树
    @SuppressWarnings("unchecked")
    public TreeParent(E data) {
        treeSize = DEFAULT_TREE_SIZE;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data,-1);
        nodeNums ++;
    }
    //以根节点,指定treeSize创建树
    @SuppressWarnings("unchecked")
    public TreeParent(E data,int treeSize) {
        this.treeSize = treeSize;
        nodes = new Node[treeSize];
        nodes[0] = new Node<E>(data,-1);
        nodeNums ++;
    }
    //为指定节点添加节点
    public void addNode(E data,Node parent){
        for (int i=0;i<treeSize;i++){
            //找出数组中第一个为null的元素，该元素保存新节点
            if(nodes[i] == null){
                //创建新节点，并用指定的数组元素保存它
                nodes[i] = new Node<E>( data,pos(parent));
                nodeNums ++;
                return;
            }
        }
        throw new RuntimeException("该树已经满，无法添加新节点");
    }

    //判断树是否为空
    public boolean empty(){
        return nodes[0] == null;
    }

    //返回根节点
    public Node<E> root() {
        return nodes[0];
    }

    //返回指定节点的父节点（非根节点）
    public Node<E> parent(Node node){
        return nodes[node.parent];
    }

    //返回指定节点的所有叶子节点（非叶子节点）
    public List<Node<E>> children(Node parent){
        List<Node<E>> list = new ArrayList<Node<E>>();
        for(int i=0;i<treeSize;i++){
            //如果当前节点的父节点位置等于parent节点的位置
            if(nodes[i] != null && nodes[i].parent == pos(parent)){
                list.add(nodes[i]);
            }
        }
        return list;
    }

    //返回该树的深度
    public int deep(){
        //用于记录最大深度
        int max = 0;
        for(int i=0;i< treeSize && nodes[i] != null;i++){
            //初始化本节点的深度
            int def = 0;
            //记录当前节点的父节点的位置
            int m = nodes[i].parent;
            //如果父节点存在
            while (m != -1 && nodes[m] != null){
                //向上搜索父节点
                m = nodes[m].parent;
                def ++;
            }
            if(max < def){
                max = def;
            }
        }
        return max;
    }

    //返回含有指定的节点
    public int pos(Node node){
        for (int i=0;i<treeSize;i++){
            //找到指定的节点
            if(nodes[i] == node){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeParent<String> tp = new TreeParent<String>("root");
        Node root = tp.root();
        System.out.println(root);
        tp.addNode("节点1",root);
        tp.addNode("节点2",root);
        List<Node<String>> nodes = tp.children(root);
        System.out.println("根节点的第一个子节点：" + nodes.get(0));
        tp.addNode("节点3",nodes.get(0));
        System.out.println("此树的深度：" + tp.deep());
    }
}
