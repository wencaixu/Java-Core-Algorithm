package com.algorithm.string;


public class BF {

    public static boolean bf(String pattern,String model){
        int p = 0;
        int m = 0;
        while(p < model.length() && m < pattern.length()){
            if(model.charAt(p) == pattern.charAt(m)){
                p ++;
                m ++;
            }else{
                p = p - m + 1;
                m = 0;
            }
        }
        if(p == m){
            return true;
        }
        return false;
    }
}
