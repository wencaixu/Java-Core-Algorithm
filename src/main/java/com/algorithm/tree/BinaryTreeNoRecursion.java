package com.algorithm.tree;


public class BinaryTreeNoRecursion<Key extends Comparable<Key>,Value> {

    private class Node{

        private Key key;

        private Value value;

        private Node left,right;

        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }


}
