package DataStructures.arrays.Queue;

/**
 * 优先级队列
 *      特点：
 *          1. 数据项按照关键字进行排序，关键字最小（或者最大）的数据项往往在队列的最前面
 *          2. 数据项在插入的时候都会插入到合适的位置以确保队列的有序-----堆有更快的插入方式
 * @ClassName PriorityQue
 * @AUTHOR Blogs
 * @DATE 2019/5/22 23:06
 * @VERSION 0.1
 **/
public class PriorityQue {

    private int[] queArray;
    //总个数
    private int maxSize;
    //实际元素个数
    private int nItems;

    public PriorityQue(int size){
        queArray = new int[size];
        this.maxSize = size;
        this.nItems = 0;
    }

    //入队
    public void insert(int value){
        if (nItems == 0){
            queArray[nItems++] = value;
        }else {
            int j = nItems-1;
            //按照插入排序的方式插入新的数据,越小的越靠后，及越先入队，优先级越高
            while(j>=0 && queArray[j] <value){
                queArray[j+1] = queArray[j];
                j--;
            }
            queArray[j+1] = value;
            nItems++;
        }
    }

    //移除元素
    public int remove(){
        return queArray[--nItems];
    }

    //查看优先级最高的元素
    public int peekMin(){
        return queArray[nItems-1];
    }
}
