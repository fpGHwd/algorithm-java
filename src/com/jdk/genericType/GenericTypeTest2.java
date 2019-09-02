/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/28/19 4:31 PM
 */

package com.jdk.genericType;

import sun.rmi.runtime.Log;

public class GenericTypeTest2 {

    public class Generic<T>{
        //key这个成员变量的类型为T,T的类型由外部指定
        private T key;

        public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key = key;
        }

        public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
            return key;
        }
    }

    public void showKeyValue1(Generic<? extends Number> obj){
//        Log.d("泛型测试","key value is " + obj.getKey());
    }
}
