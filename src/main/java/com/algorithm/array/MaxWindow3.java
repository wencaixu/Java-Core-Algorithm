package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 求串的最小子串（不包含重复字符）
 */
public class MaxWindow3 {

    //时间复杂度O（n）

    public static Map<String,Integer> maxLength(String str) {
        if (str.trim().length() == 0) {
            return null;
        }
        Map<String,Integer> map = new HashMap<>(10);
        int min = 0;
        int max = 1;
        String s = "";
        while (max < str.length()) {
            if(str.charAt(max) != str.charAt(min)){
                s = str.substring(min,max + 1);
                ++max;
                if(max < str.length()){
                    String right = str.charAt(max)+"";
                    if(!s.contains(right)){
                        s += right;
                    }else{
                        min ++;
                    }
                    map.put(s,s.length());
                }
            }else{
                min ++;
                max += 1;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "abcdbghfgh";
        Map<String, Integer> stringIntegerMap = maxLength(s);
        for(String entry : stringIntegerMap.keySet()){
            System.out.println(entry+","+stringIntegerMap.get(entry));
        }
    }
}
