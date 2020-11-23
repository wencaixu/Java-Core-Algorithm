package com.algorithm.leetcode;

import java.text.DecimalFormat;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/15,0015
 * @Version V1.0
 **/
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] combine = new int[len];
        int i=0,j = 0,k=0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                combine[k++] = nums1[i++];
            }else{
                combine[k++] = nums2[j++];
            }
        }
        while(i < nums1.length){
            combine[k++] = nums1[i++];
        }
        while(j < nums2.length){
            combine[k++] = nums2[j++];
        }

        int mid = len / 2;
        if(len % 2 ==0){
            return (combine[mid]+combine[mid-1])/2.00000;
        }else{
            return combine[mid];
        }
    }

    public static void main(String[] args) {
        int []nums1 = new int[]{1,3};
        int []nums2  = new int[]{2,3};
        double medianSortedArrays = new Solution4().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
