package com.algorithm.graph.bfs;


import java.util.Scanner;
import java.util.Stack;

public class BFSPath {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Stack<Point> TMP = new Stack<>();
    private static Stack<Point> Path = new Stack<>();
    private static Stack<Point> Result = new Stack<>();

    private static int[] x = {-1, 1, 0, 0};

    private static int[] y = {0, 0, -1, 1};

    private static int[][] n = new int[5][5];

    private static int[][] visitor = new int[5][5];

    private static int min = Integer.MAX_VALUE;

    public static void dfs(int[][] n, int sx, int sy, int foot) {
        int row = n.length;
        int col = n[0].length;

        if (sx == row - 1 && sy == col - 1) {
            while (!Path.empty()) {
                Point p = Path.pop();
                TMP.push(p);
            }

            while (!TMP.empty()) {
                Point p = TMP.pop();
                Path.push(p);
                System.out.println("("+ p.x + "," + p.y + ")");
            }
            System.out.println();
            return;
        }
        if (sx < 0 || sy < 0 || sx >= row || sy >= col) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x1 = sx + x[i];
            int y1 = sy + y[i];

            //System.out.println(x1 + "   " + y1);

            if (x1 >= 0 && x1 < row && y1 >= 0 && y1 < col && n[x1][y1] == 0 && visitor[x1][y1] == 0) {
                visitor[x1][y1] = 1;
                Point point = new Point(x1, y1);
                Path.push(point);
                dfs(n, x1, y1, foot + 1);
                visitor[x1][y1] = 0;
                Path.pop();
            }
        }
    }

    public static void main(String[] args) {
        Point p = new Point(0, 0);
        Path.push(p);

        Scanner in = new Scanner(System.in);
        int c;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                c = in.nextInt();
                n[i][j] = c;
            }
        }

        dfs(n, 0, 0, 0);

        while(!Result.isEmpty()){
            Point pop = Result.pop();
            System.out.println("("+ pop.x + "," + pop.y + ")");
        }
    }
}
