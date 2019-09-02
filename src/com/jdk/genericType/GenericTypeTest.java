/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/28/19 4:12 PM
 */

package com.jdk.genericType;

public class GenericTypeTest {

    public static void main(String[] args) {

//        System.out.println(new Son6<String>("son6", "son6"));// 构造函数两个参数类型一样的
        System.out.println(new Son8<Number, Long>(8, 8L));// 构造函数 两个参数具有父子关系
    }
}


class Father<T>{
    T data;
    Father(T data){
        this.data = data;
    }
}

// 父类和子类的泛型参数具有关系
class Son8<T, E extends T> extends Father<T> {

    E otherData;

    public Son8(T data, E otherData) {
        super(data);
        this.otherData = otherData;
    }

    @Override
    public String toString() {
        return "Son8 [otherData=" + otherData + ", data=" + data + "]";
    }
}