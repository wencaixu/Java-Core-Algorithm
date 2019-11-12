package com.algorithm;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
    }

}
