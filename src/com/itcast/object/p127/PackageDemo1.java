/*
 * @Author: Suzumiya Haruhi 
 * @Date: 2019-05-04 20:26:56 
 * @Last Modified by: Suzumiya Haruhi
 * @Last Modified time: 2019-05-04 20:56:06
 */
package pack;

import packa.DemoA;
import demo.DemoB;

public class PackageDemo1{
    public static void main(String[] args){
        DemoA da = new DemoB(); // 多态
        da.show(); // 覆写了DemoA的show方法
        // da.show(); // 
    }
}

/*
流程OK

// 默认权限，公有权限。
权限和访问控制的理解，是一个东西

又想起来，其实对于机器的沟通和控制，语言并不是关键。数学的解释和其带来的直觉才是关键的。

包也是一种封装，一个文件，有十个类只有一个是public，外部也只能看到一个类。

私有只是封装的一种体现形式。默认权限在包访问也是封装的。
*/