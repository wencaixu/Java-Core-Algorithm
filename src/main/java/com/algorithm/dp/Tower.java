package com.algorithm.dp;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x;
    int y;
    int footer;

    public Node(int x, int y, int footer) {
        this.x = x;
        this.y = y;
        this.footer = footer;
    }
}

public class Tower {

    private static int[] x = {1,1};
    private static int[] y = {0,1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            int N = in.nextInt();
            int S[][] = new int[N][N];
            int V[][] = new int[N][N];
            for(int j = 0; j < N;j++){
                for(int h = 0; h <= j; h++){
                    S[j][h] = in.nextInt();
                }
            }
            int count = 0;
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(new Node(0,0,S[0][0]));
            while(!queue.isEmpty()){
                Node pop = ((ArrayDeque<Node>) queue).pop();
                if(pop.x == N && pop.y == N){
                    ++count;
                    break;
                }
                for(int k = 0; k < x.length; k ++){
                    int x1 = pop.x + x[k];
                    int y1 = pop.y + y[k];
                    if(x1 < 0 || y1 < 0 || x1 >= N || y1 >= N || V[x1][y1] == 1){
                        break;
                    }
                    //queue.add(new Node(x1,y1,pop.footer + S[i][]));
                }
            }
        }
    }
}
