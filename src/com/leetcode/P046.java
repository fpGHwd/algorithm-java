/**
 * @author suzumiya
 * @data 5/1/19 8:20 PM
 */

package com.leetcode;

import java.util.*;

public class P046 {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> answerList = new ArrayList<List<Integer>>();
//        for (int i = 0; i < nums.length; i++) {
//            int size = answerList.size();
//            if (size == 0) {
//                for (int j = 0; j < nums.length; j++) {
//                    List<Integer> intList = new ArrayList<Integer>();
//                    intList.add(nums[j]);
//                    answerList.add(intList);
//                }
//            } else {
//                for (int j = 0; j < size; j++) {
//                    List<Integer> intList = answerList.get(j);
//                    Map<Integer, String> map = new HashMap<Integer, String>();
//                    for (int l = 0; l < intList.size(); l++) {
//                        map.put(intList.get(l), "存在"); // 存在和1并没有区别
//                    }
//                    for (int k = 0; k < nums.length; k++) { // 遍历整数如果没有被用到
//                        if (map.get(nums[k]) == null) {
////                            System.out.println("k=" + k);
//                            List<Integer> newList = new ArrayList<Integer>();
//                            for (int l = 0; l < intList.size(); l++) { // 已经用到的整数的列表
//                                newList.add(intList.get(l));
//                            }
//                            newList.add(nums[k]); //
//                            System.out.println();
//                            answerList.add(newList);
//                        }
//                    }
//                }
//                if (size != answerList.size()) {
//                    for (int j = size - 1; j >= 0; j--) {
//                        answerList.remove(j);
//                    }
//                }
//            }
//        }
//
//        return answerList;
//    }

    List<List<Integer>> lli = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        permution(0,nums);
        return this.lli;
    }

    public void permution(int k, int[] nums){
        if(nums.length-1 == k){
            List<Integer> li = new ArrayList<>();
            for(int i:nums){
                li.add(i);
            }
            this.lli.add(li);
            return;
        }
        for(int i = k; i< nums.length; i++){
            swap(i,k,nums); // 换过去
            permution(k+1,nums);
            swap(i,k,nums); // 换回来
        }
    }

    public void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 记住，你的时间都是在选择中省下来的。比如在这里，所以万是开头难，不能够也不可小看开始的工作。
    // 退化所有的其他选择，放到自己会的地方，来实现更高层次的转化。
    // 不想问的话，也不想把思考的权利和追逐钥匙的权利交给别人的话，除了要忍受必经的迟来的想要感觉的痛苦，重要的不能缺少了思考的过程。
    // 取名就是一个数字啊
    public static void main(String[] args){
//        List<Integer> il = new ArrayList<Integer>(Arrays.asList(1,2,3));
        int[] nums = {1,2,3};
        List<List<Integer>> lli = new P046().permute(nums);
    }
}

//执行用时 : 1 ms, 在Permutations的Java提交中击败了100.00% 的用户
//        内存消耗 : 36.3 MB, 在Permutations的Java提交中击败了94.61% 的用户