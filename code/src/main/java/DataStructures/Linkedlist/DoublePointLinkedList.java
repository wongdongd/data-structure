package DataStructures.Linkedlist;

/**
 * 双端链表
 *      特点：
 *          1.可以在尾节点进行增加删除操作
 * @ClassName DoublePointLinkedList
 * @AUTHOR Blogs
 * @DATE 2019/5/23 22:05
 * @VERSION 0.1
 **/
public class DoublePointLinkedList {
    private Node head;
    private Node tail;

    private class Node{
        private Object data;
        private Node next;

        public Node(Object obj){
            this.data = obj;
        }
    }

    public DoublePointLinkedList(){
        head = null;
        tail = null;
    }

    //链表头新增节点
    public void addHead(Object obj){
        Node node = new Node(obj);
        if (isEmpty()){
            tail = node;
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }
    //链表尾部新增节点
    public void addTail(Object obj){
        Node node = new Node(obj);
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }
    //删除链表头
    public Object deleteHead(){
        Object obj = head.data;
        if (head.next == null){
            tail = null;
        }
        head = head.next;
        return obj;
    }
    //遍历显示
    public void display(){
        Node current = head;
        while (current.next!=null){
            System.out.println(current.data+"->");
            current = current.next;
        }
    }


    public boolean isEmpty(){
        return (head==null);
    }
}
