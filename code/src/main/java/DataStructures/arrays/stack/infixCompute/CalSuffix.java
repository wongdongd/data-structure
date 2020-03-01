package DataStructures.arrays.stack.infixCompute;

import DataStructures.arrays.stack.MyStack;

/**
 * 计算后缀表达式的值
 *      步骤：
 *          1.从左向右扫描
 *          2.遇到数字，压入栈中
 *          3.遇到运算符，弹出栈顶两个数，用运算符对两数做相应计算，结果入栈
 *          4.重复2-3，直到表达式最后
 * @ClassName CalSuffix
 * @AUTHOR Blogs
 * @DATE 2019/5/23 13:13
 * @VERSION 0.1
 **/
public class CalSuffix {

    private MyStack s;
    private String input;

    public CalSuffix(String in){
        this.input = in;
        s = new MyStack(input.length());
    }

    public int doCal(){
        int num1,num2,result;
        for (int i=0; i<input.length();i++){
            char c = input.charAt(i);
            if (c <='0' && c >='9'){
                s.push((int)(c-'0'));
            }else {
                num2 = s.pop();//注意先弹出第二个数
                num1 = s.pop();

                switch (c){
                    case '+':
                        result = num1+num2;
                        break;
                    case '-':
                        result = num1-num2;
                        break;
                    case '*':
                        result = num1*num2;
                        break;
                    case '/':
                        result = num1/num2;
                        break;
                    default:
                        result = 0;
                        break;
                }//end switch
                s.push(result);
            }
        }
        result = s.pop();
        return result;
    }
}
