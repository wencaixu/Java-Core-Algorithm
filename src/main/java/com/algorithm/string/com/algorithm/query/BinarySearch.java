package com.algorithm.string.com.algorithm.query;

public class BinarySearch {

    public <T extends Comparable> int search(T[] A, int low, int high, T n) {
        int mid = (low + high) / 2;

        if (low == high) return -1;

        if (0 < A[mid].compareTo(n)) {
            high = mid - 1;
            return search(A, low, high, n);
        } else if (0 > A[mid].compareTo(n)) {
            low = mid + 1;
            return search(A, low, high, n);
        }
        return mid;
    }

    public int binarySearch(int[] nums,int n){
        int low  = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > n){
                high = mid - 1;
            }else if(nums[mid] < n){
                low  = mid + 1;
            }else{
               return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //Integer[] t = {1, 3, 2};
        //System.out.println(new BinarySearch().search(t, 0, 2, 3));
        int[] t = {1,2,3,4};
        System.out.println(new BinarySearch().binarySearch(t,5));
    }
}
