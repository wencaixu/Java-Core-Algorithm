package com.algorithm.array;


import java.util.*;

/**
 *  距离原点最近的K个点
 *  @author wencai.xu
 */
public class KPointsCloseToOrigin {

    public int[][] kClosest(int[][] points, int K) {
       if(points.length == 0 || K == 0){
           return null;
       }

       PriorityQueue<int[]> priority = new PriorityQueue<>(K, (o1, o2) -> {
           int d1 = o1[0] * o1[0] + o1[1] * o1[1];
           int d2 = o2[0] * o2[0] + o2[1] * o2[1];
           return d1 - d2;
       });
       priority.addAll(Arrays.asList(points));
       int [][] res = new int[K][2];
       for(int i = 0; i < K; i++){
           res[i] = priority.poll();
       }
       return res;
    }
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int K = 1;
        int[][] ints = new KPointsCloseToOrigin().kClosest(points, K);
        for(int i = 0; i < ints.length; i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }

}
