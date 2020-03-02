package com.algorithm.string.com.algorithm.graph.dfs;

import java.util.Scanner;

public class DFSPrimeRing {

    private static int Graph[];

    private static int Visit[];

    private static int n;

    private static int c;

    private static boolean isPrime(int n) {
        boolean flag = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                flag = false;
            }
        }
        return flag;
    }

    public static void dfs(int k, int s) {
        if (s == n && isPrime(k + 1)) {
            for (int i = 1; i < n; i++) {
                System.out.print(Graph[i] + " ");
            }
            System.out.println(Graph[n]);
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (Visit[i] == 1) continue;
            if (Visit[i] == 0 && i >= 1 && i <= n && isPrime(k + i)) {
                Graph[s + 1] = i;
                Visit[i] = 1;
                dfs(i, s + 1);
                Visit[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            c++;
            Graph = new int[n + 1];
            Visit = new int[n + 1];

            Graph[1] = 1;
            Visit[1] = 1;
            System.out.printf("Case %d:\r\n",c);
            dfs(1, 1);
            System.out.println();
        }
    }
}
