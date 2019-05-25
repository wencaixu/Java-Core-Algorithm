package com.algorithm.graph.dfs;


import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Compress {

    private static String inv(String s) {
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < s.length(); i++) {
            int c = Integer.parseInt(s.charAt(i) + "");
            if (!treeMap.containsKey(c)) {
                treeMap.put(c, 1);
            } else {
                treeMap.put(c, treeMap.get(c) + 1);
            }
        }
        Iterator iterator = treeMap.keySet().iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            Integer next = (Integer) iterator.next();
            builder.append(treeMap.get(next)).append(next);
        }
        return builder.toString();
    }

    private static boolean selfInv(String s) {
        boolean flag = false;
        if (s.equals(inv(s))) {
            flag = true;
        }
        return flag;
    }

    private static int selfInvJ(String s, int k) {
        String t = inv(s);
        if (s.equals(t)) {
            return k;
        } else {
            if (k <= 15) {
                return selfInvJ(t, ++k);
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int J = 0;
        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("-1")) {
                break;
            }
            //1
            if (selfInv(s)) {
                System.out.println(s + " is self-inventorying");
                J = 1;
            }
            //2
            if(J != 1){
                J = selfInvJ(s, 0);
                if (J >= 2) {
                    System.out.println(s + " is self-inventorying after " + J + " steps");
                }else{
                    J = 0;
                }
            }

            //3
            if((J != 2) && (J != 1)){
                String inv = "";
                String[] tmp = new String[16];
                for (int i = 0; i < 15; i++) {
                    String ss = inv(s);
                    tmp[i] = ss;
                }
                for (int k = 2; k < 14; k++) {
                    for (int i = 0; i < 15 - k; i++) {
                        for (int l = k; l < 15; l++) {
                            if (tmp[l - k].equals(tmp[l])) {
                                System.out.println(s + " enters an inventory loop of length " + k);
                                J = 3;
                                break;
                            }
                            if(J == 3){
                                break;
                            }
                        }
                        if (J == 3) {
                            break;
                        }
                    }
                }
                if (J == 0) {
                    System.out.println(inv + " can not be classified after 15 iterations");
                }
            }
        }
    }
}
