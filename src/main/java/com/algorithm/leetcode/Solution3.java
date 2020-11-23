package com.algorithm.leetcode;

import kotlin.text.MatchGroup;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/12,0012
 * @Version V1.0
 **/
public class Solution3 {

    // 0 <= s.length <= 5 * 104

    public int lengthOfLongestSubstring(String s) {
        if("".equals(s) || s.length() == 0){
            return 0;
        }
        int res = 0,left=0,right=0;
        Set<Character> set = new HashSet<>();
        while(left < s.length() && right < s.length()){
            if(set.contains(s.charAt(right))){
                if(set.contains(s.charAt(left))){
                    set.remove(s.charAt(left));
                }
                left += 1;
            }else{
                set.add(s.charAt(right));
                right += 1;
                res = Math.max(res,set.size());
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring5(String s){
        if("".equals(s) || s.length() == 0){
            return 0;
        }
        int ans = 0;
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char iChar = s.charAt(i);
            if(queue.contains(iChar)){
                ans = Math.max(queue.size(),ans);
                while(!queue.isEmpty() && queue.peekFirst() != iChar){
                    queue.removeFirst();
                }
                if(!queue.isEmpty()){
                    queue.removeFirst();
                }
            }
            queue.addLast(iChar);
            ans = Math.max(queue.size(),ans);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int res = 0,left = 0;
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            if(map.keySet().contains(sc)){
                left = Math.max(left,map.get(sc)+1);
            }
            map.put(sc,i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring5("acbc"));
    }

}
