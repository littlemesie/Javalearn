package cn.mesie.dataStructure.queue;

/**
 * Created by 2019-04-11 00:04
 * 基于链表的队列实现
 * @author: mesie
 */
public class LinkedQueue<E> {
    /**头结点*/
    private Node<E> head;
    /**尾指针*/
    private Node<E> rear;
    /**队列大小*/
    private int size;

    public LinkedQueue(){
        head = rear = new Node<E>(null);
    }

    /**
     * 添加元素到队尾
     * @param data
     */
    public void put(E data){
        Node<E> node = new Node<E>(data);
        rear.next = node;
        rear = node;
        size ++;
    }

    /**
     * 删除队头并返回队头元素的值
     * @return
     */
    public E pop(){
        if(!isEmpty()){
            E e = null;
            Node<E> temp = head.next;
            head.next = temp.next;
            e = temp.data;

            temp.data = null;
            temp.next = null;
            size--;
            return e;
        }
        return null;
    }

    /**
     * 返回队头元素的值
     * @return
     */
    public E peek() {
        if (!isEmpty()) {
            return head.next.data;
        }
        return null;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 队列大小
     * @return
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> cur = head.next;
        StringBuilder sb = new StringBuilder();
        while(cur != null){
            sb.append(cur.data).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for(int i = 0;i<arr.length;i++){
            queue.put(arr[i]);
        }
        System.out.println(queue);
        System.out.println(queue.peek());
    }
}
