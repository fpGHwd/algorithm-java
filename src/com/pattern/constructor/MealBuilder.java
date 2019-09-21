/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/4/19 8:30 PM
 */

package com.pattern.constructor;

public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }
}
