package com.jdk.doublecheck;

public class SingletonWithoutVolatile {
    private static SingletonWithoutVolatile instance;
    private SingletonWithoutVolatile(){}

    public static SingletonWithoutVolatile getInstance(){
        if(instance == null)instance = new SingletonWithoutVolatile();
        return instance;
    }
}
