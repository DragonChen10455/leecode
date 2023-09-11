package array;


public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
//            mid = (start + end) / 2;
            mid = start + ((end - start)) / 2;
//            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return -1;
    }
}
