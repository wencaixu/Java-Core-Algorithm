package com.algorithm.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class NodeS {
    int x;
    int y;
    int foot;

    public NodeS(int x, int y, int foot) {
        this.x = x;
        this.y = y;
        this.foot = foot;
    }
}

public class Stairs {

    private static final int[] DX = {-1, 1, 0, 0};

    private static final int[] DY = {0, 0, 1, -1};

    private static int ex,ey,sx,sy;

    private static boolean isValid(int x1, int y1, int[][] V, char[][] A) {
        if (x1 < 0 || y1 < 0 || x1 >= A.length || y1 >= A[0].length || A[x1][y1] == '*' || V[x1][y1] == 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int M = in.nextInt();
            int N = in.nextInt();
            char[][] A = new char[M][N];
            int[][] V = new int[M][N];
            for (int i = 0; i < M; i++) {
                A[i] = in.next().toCharArray();
                for (int j = 0; j < A[i].length; j++) {
                    if(A[i][j] == 'S'){
                        sx = i;
                        sy = j;
                    }
                    if(A[i][j] == 'T'){
                        ex = i;
                        ey = j;
                    }
                }
            }

            V[sx][sy] = 1;

            Queue<NodeS> queue = new ArrayDeque<>();
            queue.add(new NodeS(sx, sy, 0));

            while (!queue.isEmpty()) {
                NodeS poll = ((ArrayDeque<NodeS>) queue).pop();
                for (int i = 0; i < DX.length; i++) {
                    int x1 = poll.x + DX[i];
                    int y1 = poll.y + DY[i];
                    int step = poll.foot + 1;
                    //valid
                    if (isValid(x1, y1, V, A)) {
                        V[x1][y1] = 1;
                        if (A[x1][y1] == '|') {
                            V[x1][y1] = 0;
                            if ((i <= 1 && step % 2 == 1) || (i > 1 && step % 2 == 0)) {
                                x1 = poll.x + DX[i];
                                y1 = poll.y + DY[i];
                                if (V[x1][y1] == 1)
                                    continue;
                                else
                                    V[x1][y1] = 1;
                            } else {
                                x1 = poll.x;
                                y1 = poll.y;
                            }
                        }

                        if(A[x1][y1] == '-'){
                            V[x1][y1] = 0;
                            if((i > 1 && step % 2 == 1) || (i <= 1 && step % 2 == 0)){
                                x1 = poll.x + DX[i];
                                y1 = poll.y + DY[i];
                                if(V[x1][y1] == 1)
                                    continue;
                                else
                                    V[x1][y1] = 1;
                            }else{
                                x1 = poll.x;
                                y1 = poll.y;
                            }
                        }
                        if(x1 == ex && y1 == ey){
                            System.out.printf("%d",step);
                            return;
                        }
                        queue.add(new NodeS(x1,y1,step));
                    }
                }
            }
        }
        in.close();
    }
}
