package Algorithms.sortAlgorithms;

/**
 * 插入排序
 *    步骤：
 *      1.标记代排序元素，左边为局部有序组，将待排序元素与有序组依次比较
 *      2.将大该元素的有序组依次右移，并将该元素插入
 *      3.从i=1的位置开始依次重复上述过程
 * @ClassName InsertSort
 * @AUTHOR Blogs
 * @DATE 2019/5/21 23:16
 * @VERSION 0.1
 **/
public class InsertSort {

    public static int[] insertSort(int[] array){
        //将i=0看成局部有序组
        for (int i = 1; i < array.length; i++) {

            //标记待排序元素
            int temp = array[i];
            //记录元素位置
            int j = i;
            //大于该元素的值依次右移
            while (j>0 && array[j-1]>temp){
                array[j] = array[j-1];
                j--;
            }
            //插入元素
            array[j] = temp;
        }
        return array;
    }

    public static void display(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        int[] array = {1,3,9,4,2,5,8};
        display(insertSort(array));
    }
}
