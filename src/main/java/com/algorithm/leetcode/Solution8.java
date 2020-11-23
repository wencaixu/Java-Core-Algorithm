package com.algorithm.leetcode;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/21,0021
 * @Version V1.0
 **/
public class Solution8 {

    public int myAtoi(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int blank = 0;
        int result = 0;
        while (blank < s.length() && ' ' == s.charAt(blank)) {
            blank++;
        }
        int sign = 1;
        if (blank < s.length() && (s.charAt(blank) == '+' || '-' == s.charAt(blank))) {
            sign = (s.charAt(blank++) == '-') ? -1 : 1;
        }
        while (blank < s.length() && s.charAt(blank) >= '0' && s.charAt(blank) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(blank) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + s.charAt(blank++) - '0';
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("2147483648"));
    }
}
