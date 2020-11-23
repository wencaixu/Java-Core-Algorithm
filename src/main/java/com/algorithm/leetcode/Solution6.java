package com.algorithm.leetcode;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/20,0020
 * @Version V1.0
 **/
public class Solution6 {

    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) {
            return s;
        }
        // 返回值
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        // 周期元素个数
        int cycleLen = 2 * numRows - 2;
        // 行数
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j + i < n; j+= cycleLen){
                ret.append(s.charAt(j+i));
                if(i != 0 && i != numRows-1 && j+cycleLen-i<n){
                    ret.append(s.charAt(j+cycleLen-i));
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution6().convert("PAYPALISHIRING",3));

    }
}
