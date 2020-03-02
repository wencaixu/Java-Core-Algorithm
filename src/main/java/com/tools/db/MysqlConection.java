package com.tools.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlConection {

    static {
        try {
            Class.forName(Constants.MYSQL_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(Constants.MYSQL_URI, Constants.MYSQL_USER, Constants.MYSQL_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * PrepareStatement
     *
     * @param date
     */
    public static void insertBatch(List<String> date){
        if(date.size() == 0){
            return;
        }
        PreparedStatement ps = null;
        Connection conn = getConnection();
        String sql = "insert into mysql_insert_test(id,username,password) value (?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < date.size(); i++){
            try {
                ps.setInt(1,i);
                ps.setString(2,date.get(i));
                ps.setString(3,"pass");
                ps.addBatch();
                if(i % 100 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                    /* conn.commit(); */
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //剩余数据不足10条，执行批处理
        try {
            ps.executeBatch();
            ps.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps,conn,null);
        }
    }

    public static void insertBatchByStatement(List<String> date){
        if(date.size() == 0){
            return;
        }
        Connection conn = getConnection();
        Statement batch = null;
        try {
            batch = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            for(int i = 0; i < date.size(); i++){
                String sql = "insert into  mysql_insert_test(id,username,password) value ("+(i+100)+","+date.get(i)+",'pass')";
                batch.addBatch(sql);
                if(i % 10 == 0){
                    batch.executeBatch();
                    batch.clearBatch();
                }
            }
            batch.executeBatch();
            batch.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null,conn,batch);

        }
    }

    public static void close(PreparedStatement ps,Connection connect,Statement statement){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connect != null){
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 5000;i++){
            list.add(i + "");
        }
        insertBatchByStatement(list);
        long endTime = System.currentTimeMillis();
        System.out.printf("escape time %f",(endTime-startTime));
    }

}
