package Algorithms.sortAlgorithms;

import java.util.Arrays;

/**
 * 归并排序
 *      1.归并排序的思想是把一个数组分成两半，排序每一半，然后将数组的两半归并成为一个有序的数组
 *      2.把每一半都分为四分之一，对每个四分之一进行排序，然后把它们归并成一个有序的一半。
 *      3.类似的，如何给每个四分之一数组排序呢？把每个四分之一分成八分之一，对每个八分之一进行排序，
 *      4.以此类推，反复的分割数组，直到得到的子数组是一个数据项，那这就是这个递归算法的边界值，也就是假定一个数据项的元素是有序的
 * @ClassName MergeSort
 * @AUTHOR Blogs
 * @DATE 2019/5/24 20:48
 * @VERSION 0.1
 **/
public class MergeSort {

    /**
     * 合并两个数组为有序数组
     * @param array 以mid分界，左边为一个有序数组，右边为一个有序数组
     * @param start
     * @param mid 中间数的下标从 mid+1开始
     * @param end
     */
    public static void merge(int[] array,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        //左右两边比较合并起来
        while (i<=mid && j<=end){
            if (array[i] < array[j]){
                temp[k++] = array[i++];

            }else {
                temp[k++] = array[j++];
            }
        }
        //左边还剩下的
        while (i<=mid){
            temp[k++] = array[i++];
        }
        //右边还剩下的
        while (j<=end){
            temp[k++] = array[j++];
        }
        System.out.println("temp:"+Arrays.toString(temp));
        //把新数组赋给原来的
        for (int l = 0; l < temp.length; l++) {
            array[l+start] = temp[l];
        }
        //System.out.println("merge:"+ Arrays.toString(array));
    }

    public static int[] mergeSort(int[] array,int start,int end){
        if (end>start){
            int mid = (end-start)/2+start;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {2,1,4,7,3,5,9};
        mergeSort(a,0,6);
    }
}
