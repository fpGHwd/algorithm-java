/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/5/19 10:47 AM
 */

package com.pattern.adapter;

public class M5DataLine implements Target {
    @Override
    public void connection() {
        System.out.println("使用小米5的数据线连接");
    }
}
