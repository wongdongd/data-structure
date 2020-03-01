package Algorithms.sortAlgorithms;

import java.util.Arrays;

/**
 * 希尔排序------防止插入排序时最小元素在后边，需要移动次很多元素
 *      1.基于直接插入排序
 *      2.加大插入排序中元素的间隔，并在这些有间隔的元素中进行插入排序
 *      3.当这些数据项排过一趟序后，希尔排序算法减小数据项的间隔再进行排序，依次进行下去
 *      4.最后间隔为1时，就是我们上面说的简单的直接插入排序
 * @ClassName ShellSort
 * @AUTHOR Blogs
 * @DATE 2019/5/25 20:50
 * @VERSION 0.1
 **/
public class ShellSort {

    /**
     * knuth间隔希尔排序
     * 间隔为：3h+1
     * @param array
     * @return
     */
    public static int[] shellKnuthSort(int[] array){
        int step = 1;
        while (step<=array.length/3){
            step = 3*step+1;
        }

        while(step>0){
            for (int i = step; i < array.length; i++) {
                int temp = array[i];
                //每一段都插入排序--这一段是指以step为间隔的各个数组成的数组
                int j = i;
                while(j>step-1 && temp<=array[j-step]) {
                    array[j] = array[j - step];
                    j -= step;
                }

                array[j] = temp;
            }
            step = (step-1)/3;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3,10};
        System.out.println(Arrays.toString(shellKnuthSort(array)));
    }
}
