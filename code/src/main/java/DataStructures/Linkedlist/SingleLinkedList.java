package DataStructures.Linkedlist;

/**
 * 单向链表
 *      特点：
 *          1.一个单链表的节点(Node)分为两个部分，
 *              第一个部分(data)保存或者显示关于节点的信息；
 *              另一个部分存储下一个节点的地址；
 *              最后一个节点存储地址的部分指向空值
 *          2.只可向一个方向遍历
 *          3.插入节点，只提供链表头插入，插入节点设置为头节点
 *          4.删除一个节点，将该节点的上一个节点的next指向该节点的下一个节点
 * @ClassName SingleLinkedList
 * @AUTHOR Blogs
 * @DATE 2019/5/23 20:38
 * @VERSION 0.1
 **/
public class SingleLinkedList {
    private int size;
    private Node head;

    public SingleLinkedList(){
        size = 0;
        head = null;
    }

    private class Node{
        private Object data;
        private Node next;

        public Node(Object obj){
            this.data = obj;
        }
    }
    //添加头元素
    public void addHead(Object value){
        Node node = new Node(value);
        if (size==0){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
        size++;
    }

    //删除链表头元素
    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素
    public Node find(Object obj){
        int tempSize = size;
        Node current = head;
        while (tempSize>0){
            if (!obj.equals(current.data)){
                current = current.next;
            }else {
                return current;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定元素
    public boolean delete(Object obj){
        if (size == 0){
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data!=obj){
            //全都没找到
            if (current.next == null){
                return false;
            }else {//没找到跳到下个节点
                previous = current;
                current = current.next;
            }
        }
        //删除当前节点
        if (current == head){
            head = head.next;
        }else {
            previous.next = current.next;
        }
        size--;
        return true;
    }
    //显示节点信息
    public void display(){
        Node current = head;
        while (current!=null){
            System.out.println(current.data+"->");
            current = current.next;
        }
    }

    //判空
    public boolean isEmpty(){
        return (size==0);
    }
}
