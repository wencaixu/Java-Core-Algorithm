package com.algorithm.tree;


public class RedBlackTree<Key extends Comparable, Value> {


    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    class Node {
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {

        if (x == null) return false;
        return x.color == RED;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
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

    public void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    private Node put(Node h,Key key,Value value){
        if(h == null){
            return new Node(key,value,1,RED);
        }
        int compare = key.compareTo(h.key);
        if(compare < 0) h.left = put(h.left,key,value);
        else if(compare > 0) h.right = put(h.right,key,value);
        else h.value = value;
        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && !isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && !isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    /*public void delete(Key key){
        if(!isRed(root.left) && !isRed(root.right)){
            root.color = RED;
        }
        root = delete(root,key);
        if(!isEmpty(root)){
            root.color = BLACK;
        }
    }*/

    /*private Node delete(Node h,Key key){

        if(key.compareTo(h.key) < 0){
            if(!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left,key);
        }else{
            if(isRed(h.left)){
                h = rotateRight(h);
            }
            if((key.compareTo(h.key) == 0) && (h.right == null)){
                return null;
            }
            if(!isRed(h.right) && !isRed(h.right.left)){
                h = moveRedRight(h);
            }
            if(key.compareTo(h.key) == 0){
                h.value = get(h.right,min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }
            return balance(h);
        }
    }*/


    public boolean isEmpty(){

        return root.N == 0;
    }

    public static void main(String[] args) {

        RedBlackTree<String,String> redBlackTree = new RedBlackTree<>();

        redBlackTree.put("12","34");

        System.out.println(redBlackTree.size());

    }
}
