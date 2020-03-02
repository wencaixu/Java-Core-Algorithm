package com.algorithm.string.com.algorithm.graph.dfs;


import java.util.Scanner;

public class Snow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int C = in.nextInt();

        int[][] area = new int[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                area[i][j] = in.nextInt();
            }
        }


    }
}
