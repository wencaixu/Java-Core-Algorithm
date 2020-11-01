package com.algorithm.array.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * 系数矩阵的三元组压缩算法
 */
public class SparseMatrix {

    private int row;
    private int col;
    private List<Item> items = new LinkedList<>();

    public SparseMatrix(Matrix matrix){
        int[][] values = matrix.getMatrix();
        this.row = matrix.getRowCount();
        this.col = matrix.getColCount();

        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                if(values[i][j] != 0){
                    items.add(new Item(i,j,values[i][j]));
                }
            }
        }
    }

    /**
     * 稀疏函数的转置
     */
    public SparseMatrix T(){
        List<Item> newItems = new LinkedList<>();
        for(Item item : items){
            newItems.add(new Item(item.getCol(),item.getRow(),item.getValue()));
        }
        return new SparseMatrix(this.col,this.row,newItems);
    }

    public static void main(String[] args) {
        int[][] items = new int[][]{
                {1,0,0},
                {0,0,0},
                {0,3,0}
        };
        // 1,0,0
        // 0,0,3
        // 0,0,0

        Matrix matrix = new Matrix(items);
        SparseMatrix sparseMatrix = new SparseMatrix(matrix);
        // 稀疏矩阵的存储
        for(Item item:sparseMatrix.getItems()){
            System.out.println("("+item.getRow()+","+item.getCol()+","+item.getValue()+")");
        }
        // 稀疏矩阵的转置
        System.out.println("=========稀疏矩阵的转置=======");
        SparseMatrix t = sparseMatrix.T();
        for(Item item:t.getItems()){
            System.out.println("("+item.getRow()+","+item.getCol()+","+item.getValue()+")");
        }
    }

    public SparseMatrix(int row, int col, List<Item> item) {
        this.row = row;
        this.col = col;
        this.items.addAll(item);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
