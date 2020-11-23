package com.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 最长对称子串
 * @Author wencai.xu
 * @Date 2020/11/15,0015
 * @Version V1.0
 **/
public class Solution5 {

    private boolean isPalindrome(String s){
        StringBuilder palindrome = new StringBuilder(s);
        return palindrome.reverse().toString().equals(s);
    }

    /** 最简单的方法，但是会超时*/
    public String longestPalindrome1(String s) {
        String ans = "";
        int maxLen = 0;
        List<String> subStrings = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
          for(int j = i + 1; j < s.length()+1; j++){
              String substring = s.substring(i,j);
              if(isPalindrome(substring) && substring.length() > maxLen){
                  maxLen = substring.length();
                  ans = substring;
              }
          }
        }
        return ans;
    }

    /*public String longestPalindrome(String s) {
        if (s == null || s.length() == 1 || s.length() == 0) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin -= 1;
            end += 1;
        }
        return s.substring(begin + 1, end);
    }*/

    public String longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        String longest = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            String temp = helper(s,i,i);
            if(temp.length() > longest.length()){
                longest = temp;
            }
            temp = helper(s,i,i+1);
            if(temp.length() > longest.length()){
                longest = temp;
            }
        }
        return longest;
    }

    private String helper(String s,int begin,int end){
        while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)){
            begin --;
            end ++;
        }
        return s.substring(begin+1,end);
    }


    public static void main(String[] args) {
        String abcba = new Solution5().longestPalindrome("abcba");
        System.out.println(abcba);
    }
}
