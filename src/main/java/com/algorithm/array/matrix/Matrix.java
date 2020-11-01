package com.algorithm.array.matrix;

/**
 * 矩阵函数。可扩展
 */
public class Matrix {

    private int[][] matrix;
    private int rowCount;
    private int colCount;

    /**
     * 1. 默认构造方法
     */
    public Matrix() {
        this.rowCount = 3;
        this.colCount = 3;
        init(rowCount, colCount);
    }

    /**
     * 2. rowCount * colCount矩阵
     */
    public Matrix(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        init(rowCount, colCount);
    }

    /**
     * 3. 设置矩阵值
     *
     * @param matrix
     */
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.rowCount = matrix.length;
        this.colCount = matrix[0].length;
    }

    private void init(int rowCount, int colCount) {
        this.matrix = new int[rowCount][colCount];
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.colCount; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * 单位矩阵
     */

    public Matrix one(int n){
        this.rowCount = n;
        this.colCount = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    this.matrix[i][j] = 1;
                }else{
                    this.matrix[i][j] = 0;
                }
            }
        }
        return new Matrix(this.matrix);
    }

    /**
     * 转置矩阵：行转列，列转行
     */
    public Matrix T() {
        // 行数和列数互换
        int[][] matrixTemp = new int[this.colCount][this.rowCount];
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.colCount; j++) {
                matrixTemp[j][i] = matrix[i][j];
            }
        }
        return new Matrix(matrixTemp);
    }

    /**
     * 判断是否为上三角矩阵,对角线下全为0
     */
    public boolean U() {
        boolean is = true;
        for (int i = 1; i < this.rowCount; i++) {
            for (int j = 0; j < i; j++) {
                if(this.matrix[i][j] != 0){
                    is = false;
                }
            }
        }
        return is;
    }

    /**
     *  判断是否为下三角矩阵,对角线上全为0
     */
    public boolean P(){
        boolean is = true;
        for (int i = 0; i < this.rowCount; i++) {
            for (int j = i + 1; j < this.colCount; j++) {
                if(this.matrix[i][j] != 0){
                    is = false;
                }
            }
        }
        return is;
    }

    /**
     * 判断是否为对称矩阵
     */
    public boolean C(){
        boolean is = true;
        for (int i = 0; i < this.rowCount; i++) {
            for(int j = 0; j < this.colCount; j++){
                if(this.matrix[i][j] != this.matrix[j][i]){
                    is = false;
                }
            }
        }
        return is;
    }

    /**
     * 矩阵求和,必须是通行矩阵（行和列相等）
     */
    public Matrix S(Matrix m1,Matrix m2) throws Exception {
        RC RC = new RC(m1, m2).invoke();
        int[][] ms_1 = RC.getMs_1();
        int[][] ms_2 = RC.getMs_2();
        int ms_1_row = RC.getMs_1_row();
        int ms_1_col = RC.getMs_1_col();
        int ms_2_row = RC.getMs_2_row();
        int ms_2_col = RC.getMs_2_col();

        if((ms_1_row != ms_2_row) || (ms_1_col != ms_2_col)){
            throw new Exception("两个矩阵不是通行矩阵，请核查");
        }
        int[][] ms = new int[ms_1_row][ms_1_col];
        for(int i = 0; i < ms_1_row; i++){
            for(int j = 0; j < ms_1_col; j++){
                ms[i][j] = ms_1[i][j] + ms_2[i][j];
            }
        }
        return new Matrix(ms);
    }

    public static void main(String[] args) throws Exception {
        int[][] m_1 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Matrix matrix = new Matrix(m_1);
        matrix.PR();

        System.out.println("==========转置矩阵===========");
        Matrix t = matrix.T();
        t.PR();

        int[][] m_2 = new int[][]{
                {1,0,0},
                {2,3,0},
                {4,5,6}
        };

        int[][] m_3 = new int[][]{
                {1,2,3},
                {0,4,5},
                {0,0,7}
        };

        matrix = new Matrix(m_3);
        boolean u = matrix.U();
        System.out.println("是否为上三角"+u);
        boolean p = matrix.P();
        System.out.println("是否为下三角"+p);

        Matrix matrix1 = new Matrix(m_2);
        Matrix matrix2 = new Matrix(m_3);

        Matrix s = new Matrix().S(matrix1, matrix2);
        System.out.println("求和");
        s.PR();

        int[][] m_4 = new int[][]{
                {1,3,2},
                {1,0,0},
                {1,2,2}
        };

        int[][] m_5 = new int[][]{
                {0,0,2},
                {7,5,0},
                {2,1,1}
        };

        Matrix m = new Matrix().M(new Matrix(m_4), new Matrix(m_5));
        System.out.println("乘积");
        m.PR();
    }

    /**
     *  矩阵相乘最重要的方法是一般矩阵乘积。
     *  它只有在第一个矩阵的列数（column）和第二个矩阵的行数（row）相同时才有意义 [1]。
     *  一般单指矩阵乘积时，指的便是一般矩阵乘积。一个m×n的矩阵就是m×n个数排成m行n列的一个数阵
     */

    public Matrix M(Matrix m1, Matrix m2) throws Exception {
        RC RC = new RC(m1, m2).invoke();
        int[][] ms_1 = RC.getMs_1();
        int[][] ms_2 = RC.getMs_2();
        int ms_1_row = RC.getMs_1_row();
        int ms_1_col = RC.getMs_1_col();
        int ms_2_row = RC.getMs_2_row();
        int ms_2_col = RC.getMs_2_col();

        if((ms_1_col != ms_1_row)){
            throw new Exception("矩阵A的行不等于矩阵B的列");
        }
        int[][] ms = new int[ms_1_row][ms_2_col];
        for(int i = 0; i < ms_1_row; i++){
            for(int j = 0; j < ms_1_col;j++){
                ms[i][j]  = 0;
                for(int k = 0; k < ms_2_row; k++){
                    ms[i][j]  += ms_1[i][k] * ms_2[k][j];
                }
            }
        }
        return new Matrix(ms);
    }

    public void PR(){
        for(int i = 0; i < this.rowCount; i++){
            for(int j = 0; j < this.colCount; j++){
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    private class RC {
        private Matrix m1;
        private Matrix m2;
        private int[][] ms_1;
        private int[][] ms_2;
        private int ms_1_row;
        private int ms_1_col;
        private int ms_2_row;
        private int ms_2_col;

        public RC(Matrix m1, Matrix m2) {
            this.m1 = m1;
            this.m2 = m2;
        }

        public int[][] getMs_1() {
            return ms_1;
        }

        public int[][] getMs_2() {
            return ms_2;
        }

        public int getMs_1_row() {
            return ms_1_row;
        }

        public int getMs_1_col() {
            return ms_1_col;
        }

        public int getMs_2_row() {
            return ms_2_row;
        }

        public int getMs_2_col() {
            return ms_2_col;
        }

        public RC invoke() {
            ms_1 = m1.getMatrix();
            ms_2 = m2.getMatrix();
            ms_1_row = m1.getRowCount();
            ms_1_col = m1.getColCount();
            ms_2_row = m2.getRowCount();
            ms_2_col = m2.getColCount();
            return this;
        }
    }
}
