package array;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

//    public static int removeElement(int[] nums, int val) {
//        int count = 0;
//        int start = 0, end = nums.length - 1;
//        while(start <= end) {
//            if(nums[start] == val) {
//                if(start == end) break;
//                while (nums[end] == val){
//                    end--;
//                    if(end < start) {
//                        return count;
//                    }
//                }
//                swap(start++, end--, nums);
//                count++;
//            } else {
//                count++;
//                start++;
//            }
//        }
//        return count;
//    }

    public static int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length;
        while(start < end) {
            if(nums[start] == val) {
                nums[start] = nums[end - 1];
                end -= 1;
            }
            else {
                start+=1;
            }
        }
        return start;
    }

    public static void swap(int a, int b, int[] nums){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
