package DataStructures.Linkedlist;

/**
 * 有序链表
 *      从小到大排列
 * @ClassName OrderLinkedList
 * @AUTHOR Blogs
 * @DATE 2019/5/23 22:57
 * @VERSION 0.1
 **/
public class OrderLinkedList {
    private Node head;

    private class Node{
        private int data;
        private Node next;

        public Node(int obj){
            this.data = obj;
        }
    }

    public OrderLinkedList(){
        head = null;
    }

    public void insert(int obj){
        Node node = new Node(obj);
        Node current = head;
        Node pre = null;
        while (current!=null && obj>current.data){
            pre = current;
            current = current.next;
        }
        if (pre == null){//链表头
            head = node;
            head.next = current;
        }else {
            pre.next = node;
            node.next = current;
        }
    }

    public int deleteHead(){
        int data = head.data;
        head = head.next;
        return data;
    }

}
