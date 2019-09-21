/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/4/19 8:32 PM
 */

package com.pattern.constructor;

public class KFCWaiter {
    private MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }


    public Meal construct(){
        //准备食物
        mealBuilder.buildFood();
        //准备饮料
        mealBuilder.buildDrink();

        //准备完毕，返回一个完整的套餐给客户
        return mealBuilder.getMeal();
    }
}