package array;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
//    //对a[left,right]区间内的数进行快排
//    public static void quickSort(int[] generateMatrix, int left , int right) {
//        if(left >= right) {
//            return ;
//        }
//        int i = left , j = right;
//        int index = left;
//        while (i < j) {
//            while(generateMatrix[j] > generateMatrix[index] && i != j) {
//                j--;
//            }
//            while (generateMatrix[i] <= generateMatrix[index] && i != j) {
//                i++;
//            }
//            if(i != j) {
//                int temp = generateMatrix[i];
//                generateMatrix[i] = generateMatrix[j];
//                generateMatrix[j] = temp;
//            }
//        }
//        if(i == j) {
//            int temp = generateMatrix[index];
//            generateMatrix[index] = generateMatrix[i];
//            generateMatrix[i] = temp;
//            quickSort(generateMatrix,left,i-1);
//            quickSort(generateMatrix,i+1, right);
//        }
//    }

//    public static int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        quickSort(nums, 0, nums.length - 1);
//        return nums;
//    }
    public static int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
