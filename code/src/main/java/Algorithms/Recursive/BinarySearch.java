package Algorithms.Recursive;

/**
 * 递归实现二分查找
 *
 * @ClassName BinarySearch
 * @AUTHOR Blogs
 * @DATE 2019/5/24 20:39
 * @VERSION 0.1
 **/
public class BinarySearch {

    public static int find(int[] array,int start,int end,int value){

        int mid = (end-start)/2+start;
        if (value == array[mid]){
            return mid;
        }else if (start>end){
            return Integer.MIN_VALUE;
        }else {
            if (array[mid] >value){
                end = mid-1;
            }else if (array[mid] <value){
                start = mid+1;
            }

            return find(array,start,end,value);
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,4,6,8,10};
        int re = find(array,0,5,6);
        System.out.println(re);
    }
}
