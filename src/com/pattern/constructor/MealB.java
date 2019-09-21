/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/4/19 8:31 PM
 */

package com.pattern.constructor;

public class MealB extends MealBuilder {
    public void buildDrink() {
        meal.setDrink("柠檬果汁");
    }

    public void buildFood() {
        meal.setFood("鸡翅");
    }
}
