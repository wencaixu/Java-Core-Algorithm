package com.algorithm.list;

import java.util.List;

public class MaxWindow2 {
    //需要考虑等差数列公式
    public static List<List<Integer>> getWindows(int sum){
        List<List<Integer>> lists = new java.util.ArrayList<>();

        int h = 2;
        int l = 1;

        while(h > l){
            if((h+l)*(h-l+1)/2 == sum){
                List<Integer> list = new java.util.ArrayList<>();
                for(int i = l; i <= h; i++){
                    list.add(i);
                }
                lists.add(list);
                l++;
            }else if((h+l)*(h-l+1)/2<sum){
                h++;
            }else{
                l++;
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> windows = getWindows(100);

        for(int i = 0; i < windows.size(); i++){
            System.out.println(windows.get(i));
        }
    }
}
