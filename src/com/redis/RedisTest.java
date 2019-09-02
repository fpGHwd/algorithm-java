/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/30/19 9:49 PM
 */

package com.redis;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisTest {

    // 指定查询业务
    // SYS_USER_SEL_AGE_25 -- 直接和业务相关
    // SYS_USER_
    static final String SYS_USER_TABLE ="SYS_USER_TABLE";
    static final String SYS_USER_SEL_AGE_25 = "SYS_USER_SEL_AGE_25";
    static final String SYS_USER_SEL_SEX_M = "SYS_USER_SEL_SEX_M";
    static final String SYS_USER_SEL_SEX_F = "SYS_USER_SEL_SEX_F";

    static Jedis j;

    @Before
    public void  before(){
        j = new Jedis("127.0.0.1", 6379);
        j.auth("haruhi");
    }
/*
    static{
        j = new Jedis("127.0.0.1", 6379);
        j.auth("haruhi");
    }*/

    // 连接池的概念
    @Test
    public void test() {

        Map<String, String> map = new HashMap<>();

        String uid1 = UUID.randomUUID().toString();
        User u1 = new User(UUID.randomUUID().toString(), "z2", 25, "m");
        map.put(uid1, JSONObject.toJSONString(u1));

        String uid2 = UUID.randomUUID().toString();
        User u2 = new User(UUID.randomUUID().toString(), "z4", 25, "m");
        map.put(uid2, JSONObject.toJSONString(u2));

        String uid3 = UUID.randomUUID().toString();
        User u3 = new User(UUID.randomUUID().toString(), "w5", 23, "m");
        map.put(uid3, JSONObject.toJSONString(u3));

        String uid4 = UUID.randomUUID().toString();
        User u4 = new User(UUID.randomUUID().toString(), "w6", 25, "f");
        map.put(uid4, JSONObject.toJSONString(u4));

        String uid5 = UUID.randomUUID().toString();
        User u5 = new User(UUID.randomUUID().toString(), "z7", 27, "m");
        map.put(uid5, JSONObject.toJSONString(u5));

        j.hmset("SYS_USER_TABLE", map);

        for(Map.Entry<String,String> entry : map.entrySet()){
            User uo = JSONObject.parseObject(entry.getValue(), User.class);
            if(uo.getSex().equals("m")){
                j.sadd(SYS_USER_SEL_SEX_M,entry.getKey());
            }else{
                j.sadd(SYS_USER_SEL_SEX_F,entry.getKey());
            }

            if(uo.getAge() == 25){
                j.sadd(SYS_USER_SEL_AGE_25,entry.getKey());
            }
        }


        j.close();
    }

    @Test
    public void testGet(){

        Jedis j = new Jedis("127.0.0.1", 6379);
        j.auth("haruhi");

        System.out.println("table hashtable keys:");
        Set<String> ls = j.hkeys(SYS_USER_TABLE);
        System.out.println(ls);

        System.out.println("SYS_USER_SEL_SEX_M list:");
        Set<String> user_male = j.smembers(SYS_USER_SEL_SEX_M);
        System.out.println((String[])user_male.toArray());

        System.out.println("SYS_USER_SEL_SEX_F list:");
        Set<String> user_female = j.smembers(SYS_USER_SEL_SEX_F);
        System.out.println((String[])user_female.toArray());

        System.out.println("SYS_USER_SEL_AGE_25 keys:");
        Set<String> user_age_25 = j.smembers(SYS_USER_SEL_AGE_25);
        System.out.println(Arrays.toString(user_age_25.toArray()));
    }


    // 获取一个女性用户的uuid
    @Test
    public void testGetFemaleList(){
        Set<String> ss = j.smembers(SYS_USER_SEL_SEX_F);
        System.out.println( ss);
    }

    @Test
    public void testGetMaleList(){
        Set<String> ss = j.smembers(SYS_USER_SEL_SEX_M);
        System.out.println(ss);
    }

    @Test
    public void convertSetToArray(){
        Set<String> ss = j.smembers(SYS_USER_SEL_SEX_M);
        System.out.println(ss);
        ss.toArray();
        System.out.println();
    }


    static final String SYS_USER_AGE25_AND_MALE = "SYS_USER_AGE_25_AND_MALE";
    // SELECT * FROM USER WHERE AGE = 25 AND SEX = 'm';
    @Test
    public void testSQLOperation(){
        Set<String> user_ages = j.smembers(SYS_USER_SEL_AGE_25);
        Set<String> user_males = j.smembers(SYS_USER_SEL_SEX_M);

        user_ages.retainAll(user_males); // 交集求法



        // redis api
        // return but not store
        Set<String> intersectionSet = j.sinter(SYS_USER_SEL_AGE_25,SYS_USER_SEL_SEX_M);
        Iterator<String> iterator = intersectionSet.iterator();
        while(iterator.hasNext()){
//            System.out.println(iterator.next());

            String s = j.hget(SYS_USER_TABLE, iterator.next());
            User user = JSONObject.parseObject(s,User.class); // 这里需要User的无参构造函数
            System.out.println(user);

        }

        // store
        Long result = j.sinterstore(SYS_USER_AGE25_AND_MALE,SYS_USER_SEL_SEX_M, SYS_USER_SEL_AGE_25);
        System.out.println(result);


        // todo ask 可以用JSONObject转化一个字符串(已知类实例)为该类的实例数组吗?

        // 不要把redis当做关系型数据库, 就是不要想着来实现很多的业务需求, 实际上覆盖面比较小
        // 一个set只存了uuid, 不会浪费很多空间
        // redis的写入性能比较好
    }

    // set key-value and get value via key
    public static void main(String[] args) {
        j.set("jedis-key", "jedis-value");
        String value = j.get("jedis-key");
        j.close();
        System.out.println(value);
    }


}

