package com.algorithm.string.com.algorithm.array;

import java.util.Arrays;

/**
 * 获取二维数组中第K大的元素
 *
 * @author Jerry Hsu
 */
public class NthMinNum {

    public static int nthMin(int[][] A,int nth) throws Exception {
        int len = A.length * A[0].length;
        if(len < nth){
            throw new Exception("不存在");
        }
        int[] Arr = new int[len];
        int index = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                Arr[index ++] = A[i][j];
            }
        }
        Arrays.sort(Arr);
        return Arr[nth];
    }

    public static void main(String[] args) throws Exception {

    }
}
