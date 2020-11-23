package com.algorithm.leetcode;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/21,0021
 * @Version V1.0
 **/
public class Solution9 {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        StringBuilder string = new StringBuilder();
        string.append(x);
        return string.reverse().toString().equals(String.valueOf(x));
    }

    public boolean isPalindrome1(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int palindrome = 0;
        while(x > palindrome){
            palindrome = palindrome * 10 + x % 10;
            x = x / 10;
        }
        return x == palindrome || palindrome / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().isPalindrome1(121));
    }

}
