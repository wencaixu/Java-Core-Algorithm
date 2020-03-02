package com.algorithm.string.com.algorithm.other;

import java.util.Scanner;

public class WenchuanEarthquake {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int C = in.nextInt();
        for(int i = 0; i < C; i++){
            int G = in.nextInt();
            int E = G / 2;
            int H = (G - E) * 2 / 3;
            int S = G - E - H;
            int guider = 0;
            if(E % 10 != 0){
                guider += E / 10 + 1;
            }else{
                guider += E / 10;
            }
            if(H % 10  != 0){
                guider += H / 10 + 1;
            }else{
                guider += H / 10;
            }
            if(S % 10 != 0){
                guider += S / 10 + 1;
            }else{
                guider += S / 10;
            }
            System.out.println(guider);
        }
    }
}
