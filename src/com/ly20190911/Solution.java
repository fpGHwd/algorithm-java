/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 9/11/19 11:10 AM
 */

package com.ly20190911;

import java.util.ArrayList;

public class Solution {

    static int reputationOfExperiencedEmployees(int employeesCount, int[] employeeIDs,
                                         int[] employeeReputations,
                                         int numberOfLinks,
                                         ArrayList<Integer> empHierarchy)
    {
        int startRootIdx = 0;
        return getScore(startRootIdx, employeeIDs, employeeReputations,empHierarchy);
    }

    static int getScore(int rootIdx,int[] employeeIDs, int[] employeeReputations, ArrayList<Integer> empHierarchy)
    {
        int ret = 0;
        int rootId = empHierarchy.get(rootIdx);
        int leftIdx =  2 * rootIdx + 1, rightIdx = 2 * rootIdx + 2;
        int leftId = empHierarchy.get(leftIdx), rightId = empHierarchy.get(rightIdx);
        if(leftId == -1 && rightId == -1 && rootIdx % 2 != 0)return employeeReputations[rootId];
        else{
            if(leftId != -1){
                ret += getScore(leftIdx, employeeIDs, employeeReputations,empHierarchy);
            }

            if(rightId != -1){
                ret += getScore(rightIdx, employeeIDs, employeeReputations,empHierarchy);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int employeesCount = 8, employeeIDs[] = {1,2,3,4,5,6,7,8,9};
        int[] employeeReputations = {20,9,49,5,12,23,52,15,50};
        int numberOfLinks = 15;
        ArrayList<Integer> empHierarchy = new ArrayList<>();
        empHierarchy.add(1);
        empHierarchy.add(2);
        empHierarchy.add(3);
        empHierarchy.add(4);
        empHierarchy.add(5);
        empHierarchy.add(6);
        empHierarchy.add(7);
        empHierarchy.add(-1);
        empHierarchy.add(-1);
        empHierarchy.add(-1);
        empHierarchy.add(8);
        empHierarchy.add(-1);
        empHierarchy.add(-1);
        empHierarchy.add(9);
        empHierarchy.add(-1);

        System.out.println(reputationOfExperiencedEmployees(employeesCount,employeeIDs,employeeReputations,numberOfLinks,empHierarchy));

    }

}
