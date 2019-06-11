package com.algorithm.graph.dfs;


import java.util.Scanner;

public class DFSSquare {

    private static int[] edges;

    private static int[] visit;

    private static int M;

    private static boolean flag = false;

    private static int edgeLen;

    private static void dfs(int eth, int current, int k) {
        if (current == edgeLen) {
            ++eth;
            current = 0;
        }
        if (eth == 3) {
            flag = true;
            return;
        }
        for (int j = k; j < M; j++) {
            if (visit[j] == 0 && current + edges[j] <= edgeLen) {
                visit[j] = 1;
                if (flag) {
                    return;
                }
                dfs(eth, current + edges[j], j);
                visit[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N-- > 0) {
            int edgeSum = 0;
            M = in.nextInt();
            edges = new int[M];
            for (int i = 0; i < M; i++) {
                edges[i] = in.nextInt();
                edgeSum += edges[i];
            }
            visit = new int[M];

            edgeLen = edgeSum / 4;

            dfs(0, 0, 0);

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

