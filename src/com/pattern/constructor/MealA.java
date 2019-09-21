/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/4/19 8:31 PM
 */

package com.pattern.constructor;

public class MealA extends MealBuilder {
    public void buildDrink() {
        meal.setDrink("可乐");
    }

    public void buildFood() {
        meal.setFood("薯条");
    }
}
