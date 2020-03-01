package DataStructures.arrays.Queue;

/**
 * 循环队列
 *      特点：
 *          1.只允许在一端插入，在另一端删除
 *          2.先进先出FIFO
 * @ClassName MyQueue
 * @AUTHOR Blogs
 * @DATE 2019/5/22 22:46
 * @VERSION 0.1
 **/
public class MyQueue {

    private Object[] queArray;
    //队列总大小
    private int maxSize;
    //队头
    private int front;
    //队尾
    private int rear;
    //队列中实际元素个数
    private int nItems;

    //初始化大小为size的队列
    public MyQueue(int size){
        queArray = new Object[size];
        this.maxSize = size;
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //入队
    public void insert(Object value){
        if (isFull()){
            System.out.println("the queue is full");
            return;
        }else {
            if (rear == maxSize-1){
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
        }

    }
    //出队
    public Object remove(){
        Object obj = null;
        if (isEmpty()){
            System.out.println("the queue is empty");
        }else {
            obj = queArray[front];
            queArray[front] = null;
            front++;
            if (front==maxSize){
                front = 0;
            }
            nItems--;
        }
        return obj;
    }

    //查看队头元素
    public Object peek(){
        return queArray[front];
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }
    public boolean isEmpty(){
        return (nItems==0);
    }

    //队列元素个数
    public int getSize(){
        return nItems;
    }
}
