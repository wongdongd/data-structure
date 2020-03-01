package DataStructures.arrays.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 增强版栈
 *      特点：
 *          1.自动扩容
 *          2.存储不同类型数据
 *          3.初始化时不初始化容量--------数组版没有，放在链表里
 * @ClassName ArrayStack
 * @AUTHOR Blogs
 * @DATE 2019/5/22 12:56
 * @VERSION 0.1
 **/
public class ArrayStack {

    private Object[] elementData;
    private int maxSize;
    private int top;

    public ArrayStack(){
        this.elementData = new Object[10];
        this.maxSize = 10;
        this.top = -1;
    }
    public ArrayStack(int capacity){
        this.elementData = new Object[capacity];
        this.maxSize = capacity;
        this.top = -1;
    }

    //入栈
    public void push(Object value){
        //扩容
        int oldCapacity = maxSize;
        if (top >= maxSize-1){
            int newCapacity = 0;

            if ((oldCapacity<<1) - Integer.MAX_VALUE >0){
                newCapacity = Integer.MAX_VALUE;
            }else {
                newCapacity= oldCapacity<<1;
            }

            this.maxSize = newCapacity;
//            int[] newArray = new int[maxSize];
            this.elementData = Arrays.copyOf(elementData,newCapacity);
        }
        //入栈
        elementData[++top] = value;
    }
    //弹出栈顶元素
    public Object pop(){
        Object obj = peak();
        remove();
        return obj;
    }
    //获取栈顶元素
    public Object peak(){
        if (top == -1){
            return new EmptyStackException();
        }
        return elementData[top];
    }
    //移除栈顶元素
    public void remove(){
        elementData[top] = null;
        top--;
    }
    //判空
    public boolean isEmpty(){
        return (top==-1);
    }
}
