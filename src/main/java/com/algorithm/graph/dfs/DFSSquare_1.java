package com.algorithm.graph.dfs;


import java.util.Scanner;

public class DFSSquare_1 {

    private static int visit[];

    private static int[] num;

    private static int M;

    private static double sider;

    private static boolean flag = false;

    public static void dfs(int th, int h, int now) {
        int tmp = h;
        visit[h] = 1;
        if (sider == now) {
            th++;
            now = 0;
            tmp = 0;
        }
        if (th == 3) {
            flag = true;
            return;
        } else {
            for (int i = tmp; i < M; i++) {
                int position = num[i];
                if (visit[i] == 0 && now + position <= sider) {
                    dfs(th, i, now + position);
                    if(flag){
                        return;
                    }
                }
            }
        }
        visit[h] = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N-- > 0) {
            M = in.nextInt();
            double sum = 0.0;
            num = new int[M];
            for (int i = 0; i < M; i++) {
                num[i] = in.nextInt();
                sum += num[i];
            }
            visit = new int[M];
            sider = sum / 4;
            flag = false;
            dfs(0, 0, num[0]);
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
