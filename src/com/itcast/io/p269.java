/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/9/19
 * @Time:       1:15 PM
 * @Project:    algorithm
 */

package com.itcast.io;

import org.junit.Test;

import java.io.*;


class Person implements Serializable{
//    String name;

    public static final long serialVersionUID = 42L;
    String name;
    transient int age;
    static String country = "CN";
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return name+": " + age + ": " + country;
    }
}

public class p269 {

    // todo 看视频也是一种复用，就是复用。

    // 序列化
    // 操作对象的流，对象存在堆内存中。可以把堆内存的数据存放到硬盘上。

    // 问题：分割程序

    // 对象的持久化存储。对象的可序列性

    // todo 下载网盘的课程文件。源代码

    class TestObject{
        // 可序列化
        int val = 1;
        TestObject(int val){
            this.val = val;
        }
    }



    @Test
    public void testWriteObject() throws IOException{

        // FileOutputStream的重点是文件
        // ObjectOutputStream的重点是对象
        FileOutputStream fos = new FileOutputStream("object-write1.object");
//        Object o = new TestObject(3);
        Person p = new Person("lisi", 30); // 对象的数据存在与堆中
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(p);

        oos.close(); // 关闭之后


        // 这么即行就挂了，是不是不太合适

        // MotSerializableException在ObjectOutputStream的writeObject()方法的细节之中。//突然觉得不用看源代码。。只需要懂就行，文档是一个凝结了时间的东西。但是源代码就不一定了。


        // Serializable接口是没有方法的，是标记接口。
        // 盖章的猪肉是安全的。
        // serialVersion的目的是为了，Object文件中的“对象”和类的版本中的东西不一样。或者本身不一样。
        // 读取的时候持久化编号和现在使用的类的版本应该匹配，否则不应反序列化。

        // ID应该是根据类内部的成员变量和成员函数计算出来的。


        // 一个问题，不能写内部类，内部类无法被发现。报了异常。


    }


    @Test
    public void testReadObjectFromFile() throws IOException,ClassNotFoundException{

        FileInputStream fis = new FileInputStream(new File("object-write1.object"));
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object o = ois.readObject(); // 直接写Person也是没有问题的。
        Person p = (Person)o;

        System.out.println(p.toString()); // Person类覆盖了toString()方法，可以直接写


        // 拿出来用就可以了，不需要用和。

        // 测试添加person private String name开始
        // java.io.InvalidClassException: com.itcast.io.Person; local class incompatible: stream classdesc serialVersionUID = -6279825475106601928, local class serialVersionUID = -3058861760463182390
        //
        //	at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:699)
        //	at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1885)
        //	at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1751)
        //	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2042)
        //	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1573)
        //	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:431)
        //	at com.itcast.io.p269.testReadObjectFromFile(p269.java:93)
        //	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        //	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        //	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        //	at java.lang.reflect.Method.invoke(Method.java:498)
        //	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
        //	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        //	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
        //	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
        //	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
        //	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
        //	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
        //	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
        //	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
        //	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
        //	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
        //	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
        //	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
        //	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
        //	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
        //	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
        //	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
        //	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

        // 以上就是反序列化错误：类有修改

        // 如果不让java自动生成uuid，就添加版本。。
        // 一共测试四次，并没有覆盖前面的文件
        // 1。没有版本好的Person类，以及普通String name，序列化/写入，反序列化/读出，没有问题
        // 2。修改为private String name，写入，无法读出，序列号异常
        // 3。有版本号的Person类，写入，读出，没有问题
        // 4。修改为private String name，保持版本号，正常反序列化。
        // 5-6 还可以主动修改序列号（在序列化和反序列化中间），而不改变类的内容。。（其实序号是逻辑的类的版本，至少在这个序列化和反序列化的功能中是这样）
        // 果然抛出序列化错误。至此所有的情况都研究万了。


        // 静态是不能序列化的，只能把堆里的数据序列化，不能序列化方法区的静态变量。
        // 不想序列化某个属性，添加transient

        // transient 的作用： 不能序列化，保证值在堆中存在，而不在文本文件中存在。
        // 一般不存储为txt，存储为person.object // 拓展名为对象。

    }



}
