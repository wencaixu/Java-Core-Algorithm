package com.algorithm.other;


import java.util.Scanner;

public class UnimodalArray {

    private static int[] array;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }

            boolean increase = false;
            boolean decrease = false;
            boolean constant = false;

            int count = 0;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    if (!decrease && !constant) {
                        ++count;
                        increase = true;
                    }
                } else {
                    increase = false;
                }
                if (array[i] == array[i + 1]) {
                    if (!increase && !decrease) {
                        ++count;
                        constant = true;
                    }
                } else {
                    constant = false;
                }
                if (array[i] > array[i + 1]) {
                    if (!increase && !constant) {
                        ++count;
                        decrease = true;
                    }
                }else{
                    decrease = false;
                }
            }

            if (count == array.length - 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
