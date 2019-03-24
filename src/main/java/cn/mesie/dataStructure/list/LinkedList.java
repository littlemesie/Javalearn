package cn.mesie.dataStructure.list;

import java.util.Iterator;

/**
 * Created by 2019-03-24 13:42
 * 链表实现
 * @author: mesie
 */

public class LinkedList<T> implements Iterable<T>{
    /**表头**/
    private Node<T> first;
    /**指向最后一个节点的工作指针**/
    private Node<T> current;
    /**链表大小**/
    private int size;

    /**
     * 获取长度
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 添加节点
     * @param data
     */

    public void add(T data){
        Node<T> node = new Node<T>(data);
        if(first == null){
            first = node;
            current = node;
            size++;
        }else {
            current.next = node;
            current = node;
            size++;
        }
    }

    /**
     * 插入第一个位置
     * @param data
     */
    public void addFirst(T data){
        Node<T> node = new Node<T>(data);
        if(first  == null){
            first = node;
            current = node;
            size++;
            return;
        }
        node.next = first;
        first = node;
        size++;
    }

    /**
     * 在后面添加
     * @param data
     */
    public void addLast(T data){
        add(data);
    }

    /**
     * 根据索引添加节点
     * @param index
     * @param data
     */
    public void add(int index,T data){
        Node<T> node = new Node<T>(data);

        Node currentNode = getNode(index);//指向指定索引之前的节点

        if(currentNode  ==null){
            addFirst(data);
            return;
        }
        node.next=  currentNode.next;
        currentNode.next = node;
        size++;
    }
    /**
     * 得到指定索引的数据
     * @param index
     * @return 数据
     */
    public T get(int index){
        return getNode(index).next.data;
    }
    /**
     * 得到指定索引的前一个节点
     * @param index
     * @return
     */
    private Node<T> getNode(int index) {
        Node<T> node = null;
        if(index == 0){
            //插入到第一个
            return null;
        }
        if(index < size){
            //插入中间
            node = first;
            for(int i = 1; i < index; i++){
                node = node.next;
            }
            return node;
        }
        return current;
    }

    /**
     * 迭代器
     * @return
     */
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node<T> cur;
            @Override
            public boolean hasNext() {
                if(cur == null && first != null){
                    cur = first;
                    return true;
                }
                if(cur.next != null){
                    cur = cur.next;
                    return true;
                }
                return false;
            }
            @Override
            public T next() {
                return cur.data;
            }

            @Override
            public void remove() {

            }
        };
    }
    /**
     * 移除数据
     * @param data
     */
    public void remove(T data){
        //查找数据的索引
        int index = getIndex(data);
        remove(index);
    }
    /**
     * 通过数据查找第一次出现的索引
     * @param data
     * @return
     */
    private int getIndex(T data) {
        Node node = first;
        for(int i = 0; i < size; i++){
            if(node.data.equals(data)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    /**
     * 移除指定索引的数据
     * @param index
     */
    public void remove(int index){
        Node prev = getNode(index);
        Node node = getNode(index+1);
        prev.next = node.next;
        size--;
    }
    /**
     * 移除第一个
     */
    public void removeFirst(){
        first = first.next;
        size--;
    }
    /**
     * 移除最后一个
     */
    public void removeLast(){
        //查找倒数第二个节点
        Node node = getNode(size-1);
        node.next =null;
        current = node;
        size--;
    }
    /**
     * 修改指定索引的数据
     * @param index
     * @param newData
     */
    public void set(int index,T newData){
        //得到指定索引节点
        Node node = getNode(index+1);
        if(node == null){
            node = first;
        }
        //修改节点上的数据
        node.data = newData;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(23);
        list.add(4);
        list.add(43);
        list.remove(10);
        System.out.println(list.getIndex(4));
        for(Integer i : list){
            System.out.println(i);
        }

    }
}
