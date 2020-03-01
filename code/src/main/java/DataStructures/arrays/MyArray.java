package DataStructures.arrays;

/**
 *类封装数组实现数据结构
 * 功能：
 *      1.插入一条新的数据项
 *      2.寻找某一特定的数据项
 *      3.删除某一个特定的数据项
 *      4.迭代的访问各个数据项，以便显示或其他操作
 * @ClassName MyArray
 * @AUTHOR Blogs
 * @DATE 2019/5/20 21:57
 * @VERSION 0.1
 **/
public class MyArray {

    //定义一个数组
    private int[] array;
    //数组的有效长度
    private int nElems;
    //数组的最大长度
    private int length;

    //构造函数，初始化长度为size的数组-
    public MyArray(int size) {
        nElems = 0;
        this.length = size;
        array = new int[length];
    }

    /**
     * 像数组后添加值为num的元素
     * @param num
     * @return 长度越过最大值，返回false，正常返回true
     */
    public boolean add(int num){
        if (nElems == length){
            return false;
        }else {
            array[nElems] = num;
            nElems ++;
            return true;
        }
    }

    /**
     * 查找数组中值为num的元素
     * @param num
     * @return 返回num所在位置下标，没有该值返回-1
     */
    public int find(int num){
        for (int i = 0; i < nElems; i++) {
            if (array[i] == num){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中值为num的元素
     * @param num
     * @return 没有该值，返回false，删除后后边的值顺序前移，返回true
     */
    public boolean delete(int num){
        int index = find(num);
        if (index == -1){
            return false;
        }else if (index == nElems-1){
            nElems--;
        }else {
            for (int i = index; i < nElems - 1; i++) {
                array[i] = array[i + 1];
            }
            nElems--;
        }
        return true;
    }

    /**
     * 遍历数组所有有效元素
     */
    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(array[i]);
        }
    }


}
