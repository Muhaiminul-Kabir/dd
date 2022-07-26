/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myvillage.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ConnectServer {
    
    
    public Connection connectDb() throws SQLException, ClassNotFoundException {

        
        String user =  "sa";
        String pass =  "asdfghjkl";
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dburl = "jdbc:sqlserver://LAPTOP-P2UO0UDH\\NIRJONSQL:1433;databaseName=MyVillage";

        Connection con = null;
        con = DriverManager.getConnection(dburl, user, pass);
        return con;
    }

}
