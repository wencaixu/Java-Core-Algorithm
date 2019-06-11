package com.algorithm.other;


import java.util.Scanner;

public class CommonSubsequence {

    public static int result(String sq,String sp){

        if(sq.length() == 0 || sp.length() == 0){
            return 0;
        }

        int len1 = sq.length();
        int len2 = sp.length();

        String tmp = "";

        if(len1 > len2){
            tmp = sq;
            sq = sp;
            sp = tmp;
        }

        int R = 0,i = 0,j = 0;

        for(; i < sq.length();){
            for(; j < sp.length();){
                if(sq.charAt(i) == sp.charAt(j)){
                    R ++;
                    i ++;
                    break;
                }else{
                    j ++;
                }
            }
            if(j == sp.length()){
                i++;
            }
        }
        return R;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String sq = in.next();
            String sp = in.next();
            System.out.println(result(sq,sp));
        }
    }
}
