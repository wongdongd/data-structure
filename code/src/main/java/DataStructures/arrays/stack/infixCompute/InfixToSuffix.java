package DataStructures.arrays.stack.infixCompute;

/**
 * 中缀表达式转后缀表达式---两个栈实现
 *    步骤：
 *         1. 初始化两个栈，运算符栈s1和存储中间结果的栈s2
 *         2.从左向右扫描中缀表达式
 *         3.遇到操作数时，压入栈s2
 *         4.遇到运算符时，比较其与s1栈顶运算符的优先级：
 *              4-1.如果s1为空，或栈顶运算符为左括号"(",直接将此运算符入栈
 *              4-2.否则，若优先级比栈顶运算符高，也将运算符压入s1，-----优先级必须为高，相同和低都不行
 *              4-3.否则，将s1栈顶运算符弹出并压入s2中，再次转到与s1中新的栈顶运算符比较
 *         5.遇到括号时：
 *              5-1.如果为左括号"("，直接入栈s1
 *              5-2.如果为右括号")",依次弹出s1栈顶运算符，并压入s2，直到遇到s1的栈顶为左括号，此时将这对括号丢弃
 *         6.重复步骤2-5，直至表达式最右边
 *         7.将s1中剩余运算符依次弹出并压入s2
 *         8.依次弹出s2的元素并输出，结果的逆序即为后缀表达式。
 * @ClassName InfixToSuffix
 * @AUTHOR Blogs
 * @DATE 2019/5/22 23:55
 * @VERSION 0.1
 **/
public class InfixToSuffix {
    //运算符栈
    private InfixStack s1;
    //中间结果栈
    private InfixStack s2;
    //输入的表达式
    private String input;

    public InfixToSuffix(String in){
        input = in;
        s1 = new InfixStack(input.length());
        s2 = new InfixStack(input.length());
    }

    public InfixStack doTrans(){
        for (int i=0; i<input.length(); i++){

            System.out.println("此刻s1栈");
            s1.display();
            System.out.println("此刻s2栈");
            s2.display();
            char c = input.charAt(i);
            switch (c){
                case '+':
                case '-':
                    gotOper(c,1);
                    break;
                case '*':
                case '/':
                    gotOper(c,2);
                    break;
                case '(':
                    s1.push(c);
                    break;
                case ')':
                    gotParen(c);
                    break;
                default:
                    s2.push(c);
                    break;
            }
        }

        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2;
    }

    public void gotOper(char c,int pre){
        while (!s1.isEmpty()){
            char top = s1.pop();

            if (top == '('){
                s1.push(top);
                break;
            }else {
                int compre = 0;
                if (top == '+' || top == '-'){
                    compre = 1;
                }else{
                    compre = 2;
                }

                //优先级比栈顶元素高，入栈
                if (pre > compre){
                    s1.push(c);
                    break;
                }else {//优先级低，将栈顶弹出，压入栈s2
                    s2.push(top);
                }
            }
        }
        //如果s1为空，运算符直接入栈
        s1.push(c);
    }

    public void gotParen(char c){
        while(!s1.isEmpty()){
            char top = s1.pop();
            if (top != '('){
                s2.push(top);
            }else {
                break;
            }
        }
    }

}
