package com.algorithm.graph.bfs;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int x;
    int y;
    int z;
    int foot;

    public Node(int x, int y, int z, int foot) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.foot = foot;
    }
}

public class BFSMaster {
    //(0,0,-1)->UP
    //(0,0,1)->DOWN
    //(1,0,0)->EAST
    //(0,0,-1)->WEST
    //(0,1,0)->SOUTH
    //(0,-1,0)->NORTH
    private final static int[] x = {0, 0, 0, 0, -1, 1};
    private final static int[] y = {0, 1, -1, 0, 0, 0};
    private final static int[] z = {-1, 0, 0, 1, 0, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int L = in.nextInt();
            int R = in.nextInt();
            int C = in.nextInt();
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            char[][][] dungeon = new char[L][R][C];
            int[][][] visitor = new int[L][R][C];
            Node start = null, exit = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = in.next();
                    dungeon[i][j] = line.toCharArray();
                    for (int k = 0; k < dungeon[i][j].length; k++) {
                        if (dungeon[i][j][k] == 'S') {
                            start = new Node(i, j, k, 0);
                        }
                        if (dungeon[i][j][k] == 'E') {
                            exit = new Node(i, j, k, 0);
                        }
                    }
                }
                //System.out.println();
            }
            // if six directions is #

            Queue<Node> queue = new ArrayDeque<Node>();
            queue.add(start);
            boolean f=false;
            while (!queue.isEmpty()) {
                Node popNode = ((ArrayDeque<Node>) queue).pop();
                if (popNode.x == exit.x && popNode.y == exit.y && popNode.z == exit.z) {
                    System.out.printf("Escaped in %d minute(s).\r\n", popNode.foot);
                    f=true;
                    break;
                }
                for (int j = 0; j < x.length; j++) {
                    int x1 = popNode.x + x[j];
                    int y1 = popNode.y + y[j];
                    int z1 = popNode.z + z[j];
                    if (x1 < 0 || y1 < 0 || z1 < 0 || x1 >= L || y1 >= R || z1 >= C
                            || dungeon[x1][y1][z1] == '#' || visitor[x1][y1][z1] == 1) {
                        continue;
                    }
                    visitor[x1][y1][z1] = 1;
                    Node newNode = new Node(x1, y1, z1, popNode.foot + 1);
                    queue.add(newNode);
                }
            }
            if(!f)
            {
                System.out.println("Trapped!");
            }
        }
    }
}
