package com.algorithm.string.com.algorithm.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//构造一棵二叉树
public class ReConstructBinaryTree {

    public static int binarySearch(int[] in,int low,int high,int n){
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(in[mid] == n){
                index = mid;
                break;
            }else if(in[mid] > n){
                high = mid - 1;
            }else if(in[mid] < n){
                low = mid + 1;
            }
        }
        return index;
    }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        int rootVal = pre[0],valueIndex = 0;
        TreeNode root = new TreeNode(rootVal);
        if(pre.length == 1){
           root.left = null;
           root.right = null;
           return root;
        }
        //int index = binarySearch(in,0,in.length - 1,root.val);
        for(valueIndex = 0; valueIndex < in.length; valueIndex ++){
            if(in[valueIndex] == root.val){
                    break;
            }
        }
            if(valueIndex > 0){
                int[] preLeft  = new int[valueIndex];
                int[] preRight = new int[valueIndex];
                for(int i = 0; i < valueIndex; i++){
                    preLeft[i]  = pre[i + 1];

                }
                for(int j = 0; j < valueIndex; j++){
                    preRight[j] = in[j] ;
                }
                root.left = reConstructBinaryTree(preLeft,preRight);
            }else{
                root.left = null;
            }

            if(pre.length - valueIndex - 1 > 0){
                int arrayIndex = pre.length - valueIndex - 1;
                int[] afterLeft  = new int[arrayIndex];
                int[] afterRight = new int[arrayIndex];
                int t = 0;
                for(int i = valueIndex + 1; i < pre.length; i++){
                    afterLeft[t] = pre[i];
                    afterRight[t] = in[i];
                    t++;
                }
                root.right = reConstructBinaryTree(afterLeft,afterRight);
            }else{
                root.right = null;
            }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in  = {4,7,2,1,5,3,8,6};

        int n = binarySearch(in,0,pre.length - 1,1);
        //TreeNode treeNode = new TreeNode(0);
        TreeNode node = reConstructBinaryTree(pre,in);
    }
}
