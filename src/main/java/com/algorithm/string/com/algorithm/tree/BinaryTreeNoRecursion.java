package com.algorithm.string.com.algorithm.tree;


public class BinaryTreeNoRecursion<Key extends Comparable<Key>, Value> {


    private Node root;

    private class Node {

        private Key key;

        private Value value;

        private Node left, right;

        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public Value get(Key key) {

        return get(key, root);
    }

    private Value get(Key key, Node root) {

        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }


    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.N;
    }


    public static void main(String[] args) {
        BinaryTreeNoRecursion<String, String> recursion = new BinaryTreeNoRecursion<>();

        System.out.println(recursion.get("2"));
        System.out.println(recursion.size());
    }

}
