package com.algorithm.leetcode;

/**
 * @Description: TODO
 * @Author wencai.xu
 * @Date 2020/11/20,0020
 * @Version V1.0
 **/
public class Solution7 {

    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reverse = reverse * 10 + pop;
            x = x / 10;
        }
        return reverse;
    }

    public int reverse1(int x) {
        if(x == 0){
            return 0;
        }
        int temp = x;
        x = Math.abs(x);
        StringBuilder res = new StringBuilder();
        do{
            res.append(x % 10);
            x = x / 10;
        }while(x != 0);

        if(temp < 0){
            String res1 = "-"+res.toString();
            if(res1.compareTo(String.valueOf(Integer.MIN_VALUE)) < 0){
                return 0;
            }
            return (int) Double.parseDouble(res1);
        }
        if(res.toString().compareTo(String.valueOf(Integer.MAX_VALUE)) < 0){
            return 0;
        }
        return (int) Double.parseDouble(res.toString());
    }

    public static void main(String[] args) {
        System.out.println("-100".compareTo(String.valueOf(Integer.MIN_VALUE)) > 0);
        System.out.println(new Solution7().reverse1(120));
    }
}
