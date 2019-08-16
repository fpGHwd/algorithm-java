/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/16/19 7:51 PM
 */

public class P0219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0 || nums.length == 0 || nums.length == 1)return false;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= k && i + j < nums.length; j++){
                if(nums[i] == nums[i + j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3}, k = 2, nums1[] = {1,0,1,1}, k1 =1, nums2[]={1,2,3,1}, k2= 3;

        P0219 p0219 = new P0219();
        System.out.println(p0219.containsNearbyDuplicate(nums, k));
        System.out.println(p0219.containsNearbyDuplicate(nums1, k1));
        System.out.println(p0219.containsNearbyDuplicate(nums2, k2));
    }
}
