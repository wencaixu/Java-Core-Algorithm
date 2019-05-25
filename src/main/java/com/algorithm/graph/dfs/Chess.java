package com.algorithm.graph.dfs;


import java.util.Scanner;

public class Chess {

    private static int count;

    private static int n = 0;

    private static int[] cols;

    private static char[][] chess;

    private static int f(int n)
    {
        if(n==0)return 1;
        return f(n-1)+f(n-2);
    }

    private static int dfs(int i, int j) {
        if (i==n) {
            if(j==0)
            {
               return 1;
            }
            return 0;
        }
        int ans=0;
        for (int s = 0; s < n; s++) {
            if (chess[i][s] == '#' && cols[s] == 0) {
                {
                    cols[s] = 1;
                    ans+=dfs(i+1,j-1);
                    cols[s] = 0;
                }
            }
        }
       ans+= dfs(i+1,j);
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            int k = in.nextInt();
            if (n == -1 && k == -1) {
                break;
            }
            chess = new char[n][n];
            cols = new int[n];
            //input
            count = 0;
            for (int i = 0; i < n; i++) {
                String border = in.next();
                chess[i] = border.toCharArray();
            }
            System.out.println(dfs(0, k));
        }
    }
}
