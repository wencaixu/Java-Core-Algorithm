package com.algorithm.string.com.algorithm.graph.dfs;

import java.util.Scanner;

public class QueueDFS {

    private static int[] y;

    private static int n;

    private static int ans;

    private static void dfs(int x) {
        if (x == n) {
            ans++;
        } else {
            //放置每一列
            for (int i = 0; i < n; i++) {
                y[x] = i;
                boolean ok = true;
                for(int j = 0; j < x; j++){
                    if(i == y[j] || i + x == j + y[j] || i - x == y[j] - j){
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    dfs(x + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            y = new int[n * n + 10];
            ans = 0;
            dfs(0);
            System.out.println(ans);
        }
    }
}
