package com.algorithm.array.matrix;

/**
 * 对称矩阵的压缩存储
 */
public class SynmeMatrix {

    private int[] synmeMatrix;
    private int colCount;


    public SynmeMatrix(int[] matrix) {
       this.synmeMatrix = matrix;
       this.colCount = matrix.length;
    }

    /**
     *  压缩矩阵的构造方法
     */

    public SynmeMatrix(Matrix matrix) throws Exception {
        if(!matrix.C()){
            throw new Exception("不是对称矩阵，不能按照对称矩阵存储");
        }
        int[][] value = matrix.getMatrix();

        this.colCount = (matrix.getColCount() + 1)*matrix.getColCount()/2;
        this.synmeMatrix = new int[this.colCount];

        for(int i = 0; i < matrix.getColCount(); i++){
            for(int j = 0; j < matrix.getColCount(); j++){
                if(i >= j){
                    synmeMatrix[i*(i+1)/2+j] = value[i][j];
                }
            }
        }
    }

    public SynmeMatrix sum(Matrix matrix) throws Exception {
        SynmeMatrix matrix1 = new SynmeMatrix(matrix);
        if(this.colCount != matrix1.colCount){
            throw new Exception("两对称矩阵维度不一致，不能进行加和");
        }

        int[] newMatrix = new int[this.colCount];
        for(int i = 0; i < this.colCount; i++){
            newMatrix[i] = matrix1.synmeMatrix[i] + this.synmeMatrix[i];
        }
        return new SynmeMatrix(newMatrix);
    }

    public void PR(){
        for(int i = 0; i < this.colCount; i++){
            System.out.print(i+"->"+this.synmeMatrix[i]+"\n");
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] m = new int[][]{
                {0,1,2},
                {1,0,3},
                {2,3,0}
        };

        int[][] m2 = new int[][]{
                {0,2,3},
                {2,0,4},
                {3,4,0}
        };
        Matrix matrix = new Matrix(m);
        Matrix matrix2 = new Matrix(m2);
        SynmeMatrix synmeMatrix = new SynmeMatrix(matrix);
        SynmeMatrix sum = synmeMatrix.sum(matrix2);
        sum.PR();
    }

    public int[] getSynmeMatrix() {
        return synmeMatrix;
    }

    public void setSynmeMatrix(int[] synmeMatrix) {
        this.synmeMatrix = synmeMatrix;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }
}
