package com.algorithm.dp;

import java.util.Scanner;

public class MaxSum {

    public static final java.lang.String as = "abcd";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n-- > 0) {
            ++count;
            int m = in.nextInt();
            int[] u = new int[m];
            for (int i = 0; i < m; i++) {
                u[i] = in.nextInt();
            }
            int positionX = 1, positionY = 1, t = 0;
            int dp[] = new int[m];
            dp[0] = u[0];
            int max = dp[0];
            for (int i = 1; i < u.length; i++) {
                if (dp[i - 1] + u[i] >= u[i]) {
                    dp[i] = dp[i - 1] + u[i];
                } else {
                    dp[i] = u[i];
                    t = i;
                }
                if (max < dp[i]) {
                    max = dp[i];
                    positionX = t + 1;
                    positionY = i + 1;
                }
            }
            System.out.println("Case "+(count)+":");
            System.out.println(max+" "+positionX+" "+positionY);
            if (n >= 1) {
                System.out.println();
            }
        }
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int m = in.nextInt();
            int sum = 0,max = Integer.MIN_VALUE;
            int low = 0,high = 0,p = 0;
            for(int j = 0; j < m; j++){
                int s = in.nextInt();
                sum += s;
                if(max < sum){
                    max = sum;
                    high = j + 1;
                    low = p +1;
                }
                if(sum < 0){
                    sum = 0;
                    p = j + 1;
                }
            }
            System.out.println("Case "+(i+1)+":");
            System.out.println(max+" "+low+" "+high);
            if(i<n-1)
                System.out.println();
        }
    }*/
}
