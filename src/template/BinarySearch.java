package template;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,7,9};
        int i = search(arr, 7, 0, arr.length - 1);
        System.out.print(i);
    }
    public static int search(int[] arr, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                left = mid + 1;
            }else if(arr[mid] > target) {
                right = mid - 1;
            }else {
                return -1;
            }
        }
        return -1;
    }
}
