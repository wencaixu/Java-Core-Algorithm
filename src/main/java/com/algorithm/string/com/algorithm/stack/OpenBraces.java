package com.algorithm.string.com.algorithm.stack;


import java.util.Stack;

/**
 * 括弧展开算法
 */
public class OpenBraces {

    public static void main(String[] args) {
        String s = "ab2(cd)ef3(gh2(mn))xyz";

        Stack<String> characters = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(")".equals(s.charAt(i)+"")){
                String c;
                String t = "";
                while(!characters.isEmpty()){
                    c = characters.pop() + "";
                    if("(".equals(c)){
                        break;
                    }
                    t += c;
                }
                int index = Integer.valueOf(characters.pop());
                String pushString = "";
                for(int j = 0; j < index; j++){
                    pushString += t;
                }
                characters.push(pushString);
            }else{
                characters.push(s.charAt(i)+"");
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!characters.isEmpty()){
            sb.append(characters.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}
