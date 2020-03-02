package com.algorithm.string.com.algorithm.graph.bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    private static final int capacity = 5; //capacity

    private static int[][] DFSGraph = new int[capacity][capacity]; //Graph

    private static int[][] visitor = new int[capacity][capacity];  //isVisitor

    private static int[] leftRight = {1, -1, 0, 0}; //left -1 right +1

    private static int[] upDown = {0, 0, 1, -1};    //up   -1 down +1

    static class Node {
        int x;//    x
        int y;//    y
        int z;//    foot

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {

        //  input
        Scanner sc = new Scanner(System.in);
        int x;
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                x = sc.nextInt();
                DFSGraph[i][j] = x;
            }
        }

        Node first = new Node(0, 0, 0);

        //  initialize
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(first);

        while (!queue.isEmpty()) {
            Node pop = ((ArrayDeque<Node>) queue).pop();  //queue front
            if (pop.x == 4 && pop.y == 4) {
                //System.out.println("result" + pop.z);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x1 = pop.x + leftRight[i];
                int y1 = pop.y + upDown[i];
                int z1 = pop.z;
                if (x1 < 0 || y1 < 0 || x1 >= capacity || y1 >= capacity || visitor[x1][y1] != 0 || DFSGraph[x1][y1] == 1) {
                    continue;
                }
                visitor[x1][y1] = z1 + 1;
                Node newNode = new Node(x1, y1, z1 + 1);
                queue.add(newNode);
            }
        }

        int x1 = 4, y1 = 4, bu = visitor[x1][y1];
        ArrayList<Node> arrayList = new ArrayList<Node>();
        arrayList.add(new Node(4,4,0));
        while (bu != 1) {
            //System.out.println("1213");
            bu--;
            for (int i = 0; i < 4; i++) {
                int nx = x1 + leftRight[i];
                int ny = y1 + upDown[i];
                if (nx >= 0 && ny >= 0 && nx < capacity && ny < capacity && visitor[nx][ny] == bu) {
                    x1 = nx;
                    y1 = ny;
                    arrayList.add(new Node(y1, x1, 0));
                    break;
                }
            }
        }
        System.out.println("(" + 0 + ", " + 0 + ")");
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.println("(" + arrayList.get(i).y + ", " + arrayList.get(i).x + ")");
        }
    }
}
