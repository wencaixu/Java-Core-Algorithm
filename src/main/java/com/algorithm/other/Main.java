package com.algorithm.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class NodeEnd {
    String input;
    int count;
    int rank;

    public NodeEnd(String input, int count, int rank) {
        this.input = input;
        this.count = count;
        this.rank = rank;
    }
}

/**
 * 小米面试，超时
 */
public class Main {

    private static final String END = "END";

    private static final String SPLIT = "#";

    private static long o2D1(int o, String D) {
        if (o == 0 || D.length() == 0) {
            return 0;
        }
        //long r = Integer.parseInt(D, o);
        long r = 0;

        while (D.length() != 0) {
            int i = 0;
            char c = D.charAt(i);
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    r += Integer.valueOf(c + "") * Math.pow(o, D.length() - 1);
                    break;
                case 'A':
                    r += 10 * Math.pow(o, D.length() - 1);
                    break;
                case 'B':
                    r += 11 * Math.pow(o, D.length() - 1);
                    break;
                case 'C':
                    r += 12 * Math.pow(o, D.length() - 1);
                    break;
                case 'D':
                    r += 13 * Math.pow(o, D.length() - 1);
                    break;
                case 'E':
                    r += 14 * Math.pow(o, D.length() - 1);
                    break;
                case 'F':
                    r += 15 * Math.pow(o, D.length() - 1);
                    break;
                default:
                    //System.out.println("Wrong");
                    break;
            }
            D = D.substring(++i);
        }
        return r;
    }


    public static long o2D(String[] split) {
        int o = Integer.parseInt(split[0]);
        String D = split[1];
        long r;
        r = o2D1(o, D);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fline = "";
        HashMap<String, NodeEnd> map = new HashMap<>(10);
        int lineNum = 0;
        while (!END.equals(fline = in.nextLine())) {
            String[] split = fline.split(SPLIT);
            long r = o2D(split);
            if (!map.containsKey(String.valueOf(r))) {
                map.put(String.valueOf(r), new NodeEnd(fline, 1, lineNum++));
            } else {
                int count = map.get(String.valueOf(r)).count;
                map.put(String.valueOf(r), new NodeEnd(map.get(String.valueOf(r)).input, ++count, lineNum));
            }
        }
        int size = map.size();

        if (size == 0) {
            System.out.println("None");
        } else {
            String[] arr = new String[map.size()];
            for (Map.Entry entry : map.entrySet()) {
                NodeEnd end = (NodeEnd) entry.getValue();
                if (end.count == 1) {
                    arr[end.rank] = end.input;
                }
            }
            boolean flag=true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    flag=false;
                    System.out.println(arr[i]);
                }
            }
            if(flag){
                System.out.println("None");
            }
        }
    }
}
