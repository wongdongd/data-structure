package Algorithms.sortAlgorithms;

/**
 * 选择排序
 *    步骤：
 *      1.从待排序数组中，找出最小元素
 *      2.如果最小元素不是待排数组第一个，将其和第一个元素交换
 *      3.余下的元素组成新的待排数组，重复上述过程
 * @ClassName SelectSort
 * @AUTHOR Blogs
 * @DATE 2019/5/21 21:26
 * @VERSION 0.1
 **/
public class SelectSort {

    public static int[] selectSort(int[] array){
        //总共需要比较n-1轮，
        for (int i = 0; i < array.length-1; i++) {
            //记录当前要比较的下标
            int min = i;
            for (int j=i+1; j<array.length; j++){
                if (array[j] < array[min]){
                    min = j;//记录当前待排数组的最小元素的下标
                }
            }
            if (min!=i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
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
        display(selectSort(array));
    }
}
