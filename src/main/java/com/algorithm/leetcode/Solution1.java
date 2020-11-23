package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * 1. 首先考虑将数据放到list里面，使用contains判断target的值是否存在，超时
 * 2. 按照方式2处理，o(N^2),但是可以通过
 * 3. 比较好的处理方案
 */
public class Solution1 {

    // 2 <= nums.length <= 105
    // -109 <= nums[i] <= 109
    // -109 <= target <= 109
    // nums的数量不超过万，O(N^2) 算法可以使用

    // 问题的大概描述：从列表中找出两数之和为某一个值的索引数组（无序）

    // 2.
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            int other = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(other == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    // 3. 时间O(N) 空间 O(N)
    public int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int other = target - nums[i];
            if(map.containsKey(other)){
                return new int[]{map.get(other),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }



    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int i1 = new Solution1().twoSum2(nums, 6)[0];
        int i = new Solution1().twoSum2(nums, 6)[1];
        System.out.println(i1+":"+i);
    }

}
