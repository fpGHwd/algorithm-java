/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/5/19 10:49 AM
 */

package com.pattern.adapter;

public class M5DataLineAdapter extends M4DataLine implements Target {

    @Override
    public void connection(){
        System.out.println("插入 type-c 转接头");
        super.connection();
    }

}
