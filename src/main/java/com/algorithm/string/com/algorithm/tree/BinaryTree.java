package com.algorithm.string.com.algorithm.tree;


//recursion
public class BinaryTree<Key extends Comparable<Key>, Value> {

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

    public int size() {

        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {

        return get(root, key);
    }

    private Value get(Node root, Key key) {
        Value value = null;

        if (root == null) {
            return null;
        } else {
            int compareResult = key.compareTo(root.key);
            if (compareResult < 0) {
                get(root.left, key);
            } else if (compareResult > 0) {
                get(root.right, key);
            } else {
                value = root.value;
            }
        }
        return value;
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node root) {
        if (root == null) return new Node(key, value, 1);
        int cmpResult = key.compareTo(root.key);
        if (cmpResult < 0) {
            root.left = put(key, value, root.left);
        } else if (cmpResult > 0) {
            root.right = put(key, value, root.right);
        } else {
            root.value = value;
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public Key min() {
        Node rootMin = min(root);
        if (rootMin == null) {
            return null;
        }
        return min(root).key;
    }

    private Node min(Node root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return min(root.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp == 0) return root;
        if (cmp < 0) return floor(root.left, key);
        Node t = floor(root.right, key);
        if (t != null) {
            return t;
        } else {
            return root;
        }
    }

    public Key select(int k){

        return select(root,k).key;
    }

    private Node select(Node root,int k){

        if(root == null) return null;
        int size = size(root.left);
        if(size > k) return select(root.left,k);
        if(size < k) return select(root.right,k - size - 1);
        return root;
    }

    public int rank(Key key){

        return rank(root,key);
    }

    private int rank(Node root,Key key){
        if(root == null) return 0;
        int cmp = key.compareTo(root.key);
        if(cmp < 0) return rank(root.left,key);
        if(cmp > 0) return 1+size(root.left)+rank(root.right,key);
        return size(root.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node root){

        if(root.left == null) return root.right;
        root.left = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node root,Key key){
        if(root == null) return null;
        int cmp = key.compareTo(root.key);
        if(cmp < 0) {
            root.left = delete(root.left,key);
        } else if(cmp > 0) {
            root.right = delete(root.right, key);
        } else{
            if(root.right == null) return  root.left;
            if(root.left == null) return  root.right;
            Node t = root;
            root = min(t.right);
            root.right = deleteMin(root.right);
            root.left = t.left;
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    public static void main(String[] args) {

        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("1", "2");

        System.out.println(tree.get("1"));
        System.out.println(tree.min());
    }
}
