package com.algorithm.stack;


import java.util.Scanner;
import java.util.Stack;

public class Html {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();
        Stack<String> strings = new Stack<>();
        String[] split = text.split(">");
        for (int i = 0; i < split.length; i++) {
            strings.add(split[i] + ">");
        }

        while(strings.isEmpty()){

            String pop = strings.pop();

        }
    }
}
