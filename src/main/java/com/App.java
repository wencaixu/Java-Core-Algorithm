package com;


import java.util.*;
import java.util.logging.Handler;

public class App {

    /*
    public static boolean isUglyNumber(int N) {
        if (N % 2 == 0) return isUglyNumber(N / 2);
        if (N % 3 == 0) return isUglyNumber(N / 3);
        if (N % 5 == 0) return isUglyNumber(N / 5);
        return N == 1 || N == 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int counter = 1, num = 1;

        while (counter < N) {
            ++num;
            if (isUglyNumber(num)) {
                ++counter;
            }
        }
        System.out.println(num);
    }*/




   /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            String next = in.next();
            arr[i] = Integer.parseInt(next);
        }

        //Arrays.sort(arr);

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i])+1);
            }
        }

        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer key = (Integer) iterator.next();
            int sKey = map.get(key);
            if(key == 0 && sKey == 1){
                count ++;
            }else {
                count = count + sKey - 1;
            }
        }
        System.out.println(count);
        //System.out.println(count);
    }*/

   public static int climb(int n){
       if(n == 1 || n == 2){
           return n;
       }
       return climb(n-1)+climb(n-2);
   }

    public static void main(String[] args) {


    }
}
