package hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {3 , 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums1, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(sumMap.get(target - nums[i]) != null) {
                res[0] = i;
                res[1] = sumMap.get(target - nums[i]);
            }
            else {
                sumMap.put(nums[i], i);
            }
        }
        return res;
    }
}
