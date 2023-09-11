package hashtable;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> record = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(record.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
