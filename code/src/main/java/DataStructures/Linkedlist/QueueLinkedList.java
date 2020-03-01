package DataStructures.Linkedlist;

/**
 * 双端链表实现队列
 *
 * @ClassName QueueLinkedList
 * @AUTHOR Blogs
 * @DATE 2019/5/23 22:43
 * @VERSION 0.1
 **/
public class QueueLinkedList {

    private DoublePointLinkedList dp;

    public QueueLinkedList(){
        dp = new DoublePointLinkedList();
    }

    public void insert(Object obj){
        dp.addTail(obj);
    }

    public Object delete(){
        return dp.deleteHead();
    }

    public void display(){
        dp.display();
    }
}
