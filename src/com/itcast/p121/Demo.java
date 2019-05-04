/*
 * @Author: Suzumiya Haruhi 
 * @Date: 2019-05-04 00:06:01 
 * @Last Modified by: Suzumiya Haruhi
 * @Last Modified time: 2019-05-04 00:11:01
 */

 package com.itcast.p121;

// 有catch就是问题被解决，没有被解决函数签名要有throws，否则不用

/**
 * try{
 * }catch{
 * }finally{
 * }
 * 
 * try{
 * }catch{
 * }
 * 
 * try{
 * }finally{
 * }
 */

 public class Demo{
     public static void main(String[] args){
        System.out.println("hello exception");
     }

     public void method(){

        try{
            System.out.println();
        }catch(Exception e){
            throw e;
        }finally{
            
        }

     }
 }