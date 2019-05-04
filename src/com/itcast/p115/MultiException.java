/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 5/3/19
 * @Time: 7:29 PM
 */

package com.itcast.p115;

public class MultiException {

    public static void main(String[] args) {
        Divide d = new Divide();
/*        try {
            int x = d.div(4, 1);
            System.out.println("x = " + x);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("finally");
        }
        System.out.println("over");*/

        try{
            int x= d.divNonNegtive(5,-1);
        }catch (Exception e){ // 多态使得着一个catch可以捕获所有的异常。
            if(e instanceof ArrayIndexOutOfBoundsException){
                System.out.println("数组越界");
            }else if(e instanceof ArithmeticException){
                System.out.println("除零");
            }else if(e instanceof NegativeDivideException){
                System.out.println("除数负数异常");
                System.out.println("异常自带信息： " + e.toString());
                System.out.println("获得getMessage()值： " + e.getMessage());
            }
        }finally {
            System.out.println("finally");
        }
        System.out.println("over");
    }
}

class Divide {
    // 编译时先报告语法错误，最后报异常。
    // 将这个问题解决完，编译就通过了。

    int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int[] arr = new int[a];
        System.out.println(arr[4]);
        return a / b;
    }

    int divNonNegtive(int a, int b)throws ArithmeticException, NegativeDivideException{
        if(b<0)throw new NegativeDivideException("初始化传给异常对象的信息。", b); // throw的时候会跳转
        return a/b;
    }
}


/**
 * 自定义的异常没有自己的所属信息时，只会打印异常名称，而不会有异常的特异信息。
 */
class NegativeDivideException extends Exception{

//    private String message;
//    NegativeDivideException(String message){ // 初始话的异常的信息，在打印的时候比较有用。
//        this.message = message;
//    }
//    public String getMessage(){
//        return message;
//    }

//    @Override
//    public String toString(){
//        return "出现了除数为负值";
//        // 整个异常的内容都是调用和被调用之间的关系，就是普通的关系而已，并算不上非常重要的内容。
//    }

    NegativeDivideException(){
        super();
    }


    // 复用，子类不需要做父类已经做了的事情。
    NegativeDivideException(String message){
        super(message);
    }

    private int value; // 获取异常发生的地方的信息
    NegativeDivideException(String message, int value){
        super(message);
        this.value = value;
    }

    public String toString(){
        return super.toString() + "这个负值除数是" + this.value;
    }

    public int getValue(){
        return this.value;
    }

    // 我觉得那个女孩子说得很对，就事论事，安全啊。啥啥啥的。都是就事论事啊。
}

// 如果在处理具体异常之后，还加了一个catch(Exception e)
// 这样会将问题隐藏，既不知道发生了什么，还让程序继续运行。原则上不允许，程序应该停掉。

/*

1.自定义异常，必须是自定义类继承Exception.
2.也可以继承throwable，但是会放弃Exception实现的方法。
3。异常和异常类都需要被抛出。具备可抛性。就是throwable体系中的独有特点。多态成throwable才会被操作。
4。


 */