/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import myvillage.model.Villager;

/**
 *
 * @author ASUS
 */
public class DataBase {

    public static void runQueryToModifyDataBase(String SQLString) throws SQLException, ClassNotFoundException {
        ConnectServer db = new ConnectServer();
        Connection conn = db.connectDb();

        Statement stmt = conn.createStatement();

        String query = SQLString;
        int num = stmt.executeUpdate(query);
        System.out.println("Row modified " + num);

    }

    public static ArrayList getSingleColumnDataList(String condition, String column, String table) throws SQLException, ClassNotFoundException {

        ConnectServer db = new ConnectServer();
        Connection conn = db.connectDb();

        if (conn != null) {
            System.out.println("connected...");
        }

        Statement stmt = conn.createStatement();

        ResultSet rst;
        String SQLString;

        if (condition.equals("")) {
            SQLString = "SELECT " + column + " FROM " + table;
        } else {
            SQLString = "SELECT " + column + " FROM " + table + " WHERE " + condition;
        }

        rst = stmt.executeQuery(SQLString);
        ArrayList<Object> list = new ArrayList<>();
        while (rst.next()) {
            String s = rst.getString(column).toString();
            list.add(s);
        }
        return list;

    }

    public static Map<String, Object> getSingleCellData(String condition, String column, String table) throws SQLException, ClassNotFoundException {
        ConnectServer db = new ConnectServer();
        Connection conn = db.connectDb();

        if (conn != null) {
            System.out.println("connected...");
        }

        Statement stmt = conn.createStatement();

        ResultSet rst;
        String SQLString;

        SQLString = "SELECT " + column + "FROM " + table + " WHERE " + condition;

        rst = stmt.executeQuery(SQLString);
        Map<String, Object> foreign = new HashMap<>();
        while (rst.next()) {
            String s = rst.getString(column).toString();
            foreign.put(column, s);
        }
        return foreign;

    }

    public static ArrayList<Map<String, Object>> getAllDataList(String condition, String table) throws SQLException, ClassNotFoundException {

        ConnectServer db = new ConnectServer();
        Connection conn = db.connectDb();

        if (conn != null) {
            System.out.println("connected...");
        }

        Statement stmt = conn.createStatement();

        ResultSet rst;
        String SQLString;

        if (condition.equals("")) {
            SQLString = "SELECT " + "*" + "FROM " + table;
        } else {
            SQLString = "SELECT " + "*" + "FROM " + table + " WHERE " + condition;
        }

        rst = stmt.executeQuery(SQLString);
        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> mList = null;

        ResultSetMetaData metadata = rst.getMetaData();
        int columnCount = metadata.getColumnCount();

        System.out.println();
        while (rst.next()) {
            mList = new HashMap<String, Object>();// had problem without reference
            String row = "";
            for (int i = 1; i <= columnCount; i++) {
                mList.put(metadata.getColumnName(i), rst.getString(i));

            }
            list.add(mList);

        }
        System.out.println(list.get(1).get("Name"));
        System.out.println("database.java 130 " + list.size());
        return list;

    }

    public static Map<String, Object> getInnerJointResultBetweenTwoRelatedTable(
            String condition,
            String table2,
            String table1,
            String table1ForeignKey,
            String table2PrimaryKey,
            String targetColumn
    ) throws SQLException, ClassNotFoundException {
        String SQLString = null;
        
        
        
        if (!condition.equals("")) {
            SQLString = " SELECT " 
                    + table2 + '.' + targetColumn 
                    + " FROM " 
                    + table1 
                    + " INNER JOIN " 
                    + table2 
                    + " ON " 
                    + table1 + '.' + table1ForeignKey 
                    +" = " 
                    + table2 + '.' + table2PrimaryKey 
                    + " WHERE " 
                    + condition;
        } else {
            SQLString = "SELECT " 
                    + table2 + '.' + targetColumn 
                    + " FROM " 
                    + table1 
                    + " INNER JOIN " 
                    + table2 
                    + " ON " 
                    + table1 + '.' + table1ForeignKey 
                    + " = " 
                    + table2 + '.' + table2PrimaryKey;
        }
        System.out.println(SQLString);
        
        ConnectServer db = new ConnectServer();
        Connection conn = db.connectDb();

        if (conn != null) {
            System.out.println("connected...");
        }

        Statement stmt = conn.createStatement();

        ResultSet rst;
        rst = stmt.executeQuery(SQLString);
        Map<String, Object> result = new HashMap<>();
        while (rst.next()) {
            String s = rst.getString(targetColumn).toString();
            result.put(targetColumn, s);
        }
        return result;
    }
}
