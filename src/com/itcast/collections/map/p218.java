/*
 * Created by Intellij IDEA.
 * @Author:     suzumiya
 * @Date:       5/13/19
 * @Time:       9:39 PM
 * @Project:    algorithm
 */

package com.itcast.collections.map;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class p218 {

    /**
     * Date
     */

    @Test
    public void test(){

        /**
         * 先玩一下把大家
         */

        Date d = new Date();
        System.out.println(d); // Mon May 13 21:43:41 CST 2019

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm:ss");
        String ret = sdf.format(d);
        System.out.println(ret);

        /**
         * Mon May 13 21:50:44 CST 2019
         * 2019年05月13日 09:50:44
         *
         * Mon May 13 21:51:05 CST 2019
         * 2019年05月13日 21:51:05
         *
         * 星期E自带本地化
         */


    }
}
