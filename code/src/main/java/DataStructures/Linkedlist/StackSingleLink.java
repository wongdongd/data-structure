package DataStructures.Linkedlist;

/**
 * 单链表实现栈
 *      1.栈的pop()方法对应单链表的deleteHead()
 *      2.栈的push()方法对应单链表的addHead()
 * @ClassName StackSingleLink
 * @AUTHOR Blogs
 * @DATE 2019/5/23 21:31
 * @VERSION 0.1
 **/
public class StackSingleLink {
    private SingleLinkedList link;

    public StackSingleLink(){
        link = new SingleLinkedList();
    }

    public void push(Object obj){
        link.addHead(obj);
    }

    public Object pop(){
        return  link.deleteHead();
    }

    public void display(){
        link.display();
    }

}
