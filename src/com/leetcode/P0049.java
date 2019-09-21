/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/12/19 4:16 PM
 */

package com.leetcode;

import java.util.*;

class P0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = String.valueOf(letters);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new P0049().groupAnagrams(strs));
    }
}