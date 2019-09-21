/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/5/19 10:51 AM
 */

package com.pattern.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        Target target = new M5DataLine();
        target.connection();

        Target adapter = new M5DataLineAdapter();
        adapter.connection();
    }
}
