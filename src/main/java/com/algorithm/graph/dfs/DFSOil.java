package com.algorithm.graph.dfs;

import java.util.Scanner;
// if oil[i][j] == '#' && visit[i][j] == 0
//    tag visitor according to eight directions 1
//    count ++;
public class DFSOil {

    private static int[] x = {1, -1, 0, 0, -1, -1, 1, 1};
    private static int[] y = {0, 0, 1, -1, -1, 1, -1, 1};

    private static char[][] oil;

    private static int[][] visit;

    private static void dfs(int i, int j) {
        visit[i][j] = 1;
        for (int k = 0; k < x.length; k++) {
            int x1 = i + x[k];
            int y1 = j + y[k];
            if (x1 < 0 || y1 < 0 || x1 >= oil.length || y1 >= oil[0].length
                    || oil[x1][y1] == '*' || visit[x1][y1] == 1) {
                continue;
            }
            dfs(x1, y1);
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            if (m == 0 && n == 0) {
                break;
            }
            oil = new char[m][n];
            visit = new int[m][n];
            for (int i = 0; i < m; i++) {
                String line = in.next();
                oil[i] = line.toCharArray();
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (oil[i][j] == '@' && visit[i][j] == 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
