package com.algorithm.graph.dfs;


import java.util.Scanner;

public class SudoKu {

    static int[][] a = new int[10][10];
    static int[][] row = new int[10][10];//x row i
    static int[][] col = new int[10][10];//y col i
    static int[][] vis = new int[10][10];//9 big
    static boolean flag;

    static void dfs(int x, int y) {
        if (x == 9) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
            return;
        }
        //当某一单元格等于0时候可以放置
        if (a[x][y] == 0) {
            int q = x / 3 * 3 + y / 3;
            for (int i = 1; i <= 9; i++) {//单元格试探
                if (row[x][i] == 0 && col[y][i] == 0 && vis[q][i] == 0) {
                    a[x][y] = i;
                    row[x][i] = 1;
                    col[y][i] = 1;
                    vis[q][i] = 1;
                    //按照摆放一行，再摆放下一行
                    if (y < 8) dfs(x, y + 1);
                    else dfs(x + 1, 0);

                    if (flag) return;
                    row[x][i] = 0;
                    col[y][i] = 0;
                    vis[q][i] = 0;
                    a[x][y] = 0;//注意
                }
            }

        } else {
            if (y < 8) dfs(x, y + 1);
            else dfs(x + 1, 0);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            for (int i = 0; i < 9; i++) {
                String s = scanner.next();
                for (int j = 0; j < 9; j++) {
                    a[i][j] = Integer.parseInt(s.charAt(j) + "");
                    vis[i][j + 1] = col[i][j + 1] = row[i][j + 1] = 0;

                }
            }

            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++) {
                    if (a[i][j] != 0) {
                        row[i][a[i][j]] = 1;
                        col[j][a[i][j]] = 1;
                        int q = i / 3 * 3 + j / 3;
                        vis[q][a[i][j]] = 1;
                    }
                    // System.out.println(a[i][j]);
                }
            flag = false;
            dfs(0, 0);
            //   System.out.println("fffff");
        }
    }

}
