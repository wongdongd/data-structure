package Algorithms.sortAlgorithms;

/**
 * 冒泡排序
 *  步骤：
 *     1.比较相邻两个元素，前一个比后一个大，交换两个
 *     2.遍历一遍，通过两两比较和交换，最后一个数为最大值
 *     3.最后一个不排序，重复步骤2，得到第二大的数据放在倒二位置
 *     4.重复步骤3，得到排序后的数组
 * @ClassName BubbleSort
 * @AUTHOR Blogs
 * @DATE 2019/5/21 0:17
 * @VERSION 0.1
 **/
public class BubbleSort {

    public static int[] bubbleSort(int[] array){
        //一共排length-1轮就可以排完，i从1开始
        for (int i = 1; i < array.length; i++) {
            //设定一个标记，true表示该轮没有进行交换，表明数组已经有序
            boolean flag = true;
            for (int j=0; j<array.length-i;j++){

                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
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
        display(bubbleSort(array));
    }
}
