package DataStructures.arrays.stack;

/**
 * 栈应用实例
 * @ClassName ApplicationTest
 * @AUTHOR Blogs
 * @DATE 2019/5/22 21:43
 * @VERSION 0.1
 **/
public class ApplicationTest {

    //字符串逆序
    public static void StringReversal(){
        ArrayStack stack = new ArrayStack();
        String str = "adasd";
        char[] chars = str.toCharArray();

        for (char c:chars){
            stack.push(c);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    //分隔符匹配
    public static void splitMatch(){
        ArrayStack stack = new ArrayStack(3);
        String str = "12<a[b{c}]>";
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];
                        if(c=='}' && ch != '{'
                                || c==']' && ch != '['
                                || c==')' && ch != '('){
                            System.out.println("Error:"+ch+"-"+c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        splitMatch();
    }
}
