package Algorithms.Recursive;

/**
 * 递归实现阶乘  n!
 * @ClassName Factorial
 * @AUTHOR Blogs
 * @DATE 2019/5/24 20:33
 * @VERSION 0.1
 **/
public class Factorial {

    public static int getFactorial(int n){
        if (n==0){
            return 1;
        }
        return n*getFactorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(2));
    }
}
