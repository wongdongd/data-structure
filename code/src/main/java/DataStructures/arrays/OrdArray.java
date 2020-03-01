package DataStructures.arrays;

/**
 * 有序数组
 * 功能：
 *      1.插入一条新的数据项，按顺序排列
 *      2.寻找某一特定的数据项，按二分法查找
 *      3.删除某一个特定的数据项
 *      4.迭代的访问各个数据项，以便显示或其他操作
 * @ClassName OrdArray
 * @AUTHOR Blogs
 * @DATE 2019/5/20 23:14
 * @VERSION 0.1
 **/
public class OrdArray {

    private int[] array;
    private int nElems;
    private int length;

    /**
     * 初始化大小为size的数组
     * @param size
     */
    public OrdArray(int size) {
        this.length = size;
        array = new int[length];
        nElems = 0;
    }

    /**
     * 插入数据value
     * @param value
     * @return
     */
    public boolean insert(int value){
        if (nElems == length){
            return false;
        }
        for (int i = 0; i < nElems; i++) {
            if (array[i]>value){
                for (int j=nElems; j>i; j--){
                    array[j] = array[j-1];
                }
                array[i]=value;
                nElems++;
                break;
            }
        }
        return true;
    }

    /**
     * 查找---二分法
     * @param value
     * @return 返回下标值，没有返回-1
     */
    public int find(int value){
        int lowerBound = 0;
        int upperBound = nElems;
        int curId = 0;

        while (true){
            curId = (lowerBound+upperBound)/2;
            if (array[curId] == value){
                return curId;
            }else if (lowerBound > upperBound){
                return -1;
            }else {
                if (array[curId] > value){
                    upperBound = curId - 1;
                }else {
                    lowerBound = curId + 1;
                }
            }
        }
    }

    /**
     * 删除值为value的元素
     * @param value
     * @return
     */
    public boolean delete(int value){
        int index = find(value);
        if (index == -1){
            return false;
        }else if (index == nElems-1){
            nElems--;
        }else {
            for (int i=index; i<nElems; i++){
                array[i] = array[i+1];
            }
            nElems--;
        }
        return true;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.println(array[i]);
        }
    }
}
