package com.algorithm.string.com.algorithm.graph.bfs;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Jerry
 */
public class BFSOil {

    static class Node {
        int x;
        int y;
        int adj;

        public Node(int x, int y, int adj) {
            this.x = x;
            this.y = y;
            this.adj = adj;
        }
    }

    //(1,0)->down (-1,0)->up (0,1)->right (0,-1)->left
    //(-1,-1)->up left (-1,1) up right (1,-1) down left (1,1) down right

    private static int[] x = {1, -1, 0, 0, -1, -1, 1, 1};
    private static int[] y = {0, 0, 1, -1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            if (m == 0 && n == 0) {
                break;
            }
            char[][] oil = new char[m][n];
            int[][] visit = new int[m][n];
            for (int i = 0; i < m; i++) {
                String line = in.next();
                oil[i] = line.toCharArray();
            }
            int num = 0;

            Queue<Node> queue = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (oil[i][j] == '@' && visit[i][j] == 0) {
                        num++;
                        visit[i][j] = 1;
                        queue.add(new Node(i, j, 0));
                        while (!queue.isEmpty()) {
                            Node first = ((ArrayDeque<Node>) queue).pop();
                            for (int s = 0; s < 8; s++) {
                                int tx = first.x + x[s];
                                int ty = first.y + y[s];
                                if (tx >= 0 && tx < m && ty >= 0 && ty < n && visit[tx][ty] == 0 && oil[tx][ty] == '@') {
                                    visit[tx][ty] = 1;
                                    queue.add(new Node(tx, ty, 0));
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(num);
        }
    }
}
