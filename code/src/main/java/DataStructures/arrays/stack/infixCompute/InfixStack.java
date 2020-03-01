package DataStructures.arrays.stack.infixCompute;

/**
 * @ClassName InfixStack
 * @AUTHOR Blogs
 * @DATE 2019/5/22 23:48
 * @VERSION 0.1
 **/
public class InfixStack {

    private char[] array;
    //栈大小
    private int maxSize;
    //栈顶位置
    private int top;

    public InfixStack(int size){
        this.maxSize = size;
        array = new char[size];
        top = -1;
    }

    //入栈操作
    public void push(char value){
        if (top < maxSize-1){
            array[++top] = value;
        }
    }

    //弹出栈顶元素
    public char pop(){
        return array[top--];
    }

    //访问栈顶元素
    public char peak(){
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
    
    //遍历显示
    public void display(){
        System.out.println("栈中元素为：");
        for (int i = 0; i < top+1; i++) {
            System.out.println(array[i]);
        }
    }
}
