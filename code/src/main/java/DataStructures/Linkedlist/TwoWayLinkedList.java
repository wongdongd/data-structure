package DataStructures.Linkedlist;

/**
 * 双向列表
 *      特点：
 *          每个节点存储前一个节点和后一个节点信息
 * @ClassName TwoWayLinkedList
 * @AUTHOR Blogs
 * @DATE 2019/5/23 23:27
 * @VERSION 0.1
 **/
public class TwoWayLinkedList {
    private Node head;
    private Node tail;

    private class Node{
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object object){
            this.data = object;
        }
    }

    public TwoWayLinkedList(){
        head = null;
        tail = null;
    }

    //链表头增加节点
    public void addHead(Object obj){
        Node node = new Node(obj);
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
    //链表尾增加节点
    public void addTail(Object obj){
        Node node = new Node(obj);
        if (isEmpty()){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail =node;
        }
    }

    //删除头节点
    public Object deleteHead(){
        Object obj = head.data;
        if (head.next==null){
            head = null;
        }else {
            head.next.prev = null;
            head = head.next;
        }
        return obj;
    }

    //删除尾节点
    public Object deleteTail(){
        Object obj = tail.data;
        if (head.next==null){
            head = null;
        }
        tail.prev.next = null;
        tail = tail.prev;
        return obj;
    }
    //从头显示
    public void displayForward(){
        Node current = head;
        while (current!=null){
            System.out.println(current.data+">");
            current = current.next;
        }
    }

    //从尾部显示
    public void displayBackward(){
        Node current = tail;
        while (current.prev!=null){
            System.out.println(current.data+">");
            current = current.prev;
        }
    }
    //判空
    public boolean isEmpty(){
        return (head==null);
    }
}
