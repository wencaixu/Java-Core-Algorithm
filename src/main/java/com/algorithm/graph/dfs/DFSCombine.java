package com.algorithm.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFSCombine {

    private static int[] visit;

    private static int[] resul;

    private static int n, m;

    private static List<String> result = new ArrayList<String>();

    private static void dfs(int step) {
        if (step == n) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    builder.append(resul[i]);
                } else {
                    builder.append(resul[i]).append(" ");
                }
            }
            result.add(builder.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                resul[step] = i + 1;
                dfs(step + 1);
                visit[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        for (int i = 0; i < line; i++) {
            n = in.nextInt();
            m = in.nextInt();

            visit = new int[n];
            resul = new int[n];

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int t = in.nextInt();
                if (j == n - 1) {
                    builder.append(t);
                } else {
                    builder.append(t).append(" ");
                }
            }
            dfs(0);
            String s = builder.toString();
            String rs = null;
            if (result.contains(s)) {
                int index = result.indexOf(s);
                if (index + m > result.size()) {
                    rs = result.get((index + m) % result.size());
                }else{
                    rs = result.get(index + m);
                }
            }
            System.out.println(rs);
        }
    }
}
/*

1
20 2
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 */