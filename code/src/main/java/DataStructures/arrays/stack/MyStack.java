package DataStructures.arrays.stack;

/**
 * 栈----数组实现
 *  特点：
 *      1.只能在一端进行插入和删除操作的特殊线性表
 *      2.先进后出
 * @ClassName MyStack
 * @AUTHOR Blogs
 * @DATE 2019/5/22 12:26
 * @VERSION 0.1
 **/
public class MyStack {

    private int[] array;
    //栈大小
    private int maxSize;
    //栈顶位置
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //入栈操作
    public void push(int value){
        if (top < maxSize-1){
            array[++top] = value;
        }
    }

    //弹出栈顶元素
    public int pop(){
        return array[top--];
    }

    //访问栈顶元素
    public int peak(){
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty(){
       return (top==-1);
    }

    //判断栈满了
    public boolean isFull(){
        return (top==maxSize-1);
    }
}
