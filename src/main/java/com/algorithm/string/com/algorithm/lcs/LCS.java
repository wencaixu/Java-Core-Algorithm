package com.algorithm.string.com.algorithm.lcs;

import java.util.Arrays;

public class LCS {

    public int lCS(int[] lcsArray) {
        int[] counts = new int[lcsArray.length];
        int q = 0;
        for (int i = 0; i < lcsArray.length; i++) {
            int[] TMP = lcsArray;
            int count = 0;
            for (int j = 0; j < lcsArray.length; j++) {
                if (j > i && lcsArray[j] >= TMP[i]) {
                    ++count;
                    TMP[j] = lcsArray[j];
                }
                if (i > j && lcsArray[j] <= TMP[i]) {
                    ++count;
                    TMP[j] = lcsArray[j];
                }
            }
            counts[q++] = count;
        }
        Arrays.sort(counts);
        return counts[counts.length - 1];
    }

    //别人的代码
    public int getLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        System.out.println(new LCS().getLIS(arr));
    }
}
