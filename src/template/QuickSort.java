package template;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {1,4,5,6,2};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] arr){
        quick(arr, 0, arr.length - 1);
    }
    public static void quick(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = partition(arr, start, end);
        quick(arr, start, pivot - 1);
        quick(arr, pivot + 1, end);
    }
    public static int partition(int[] arr, int left, int right){
        int tmp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= tmp){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }
}
