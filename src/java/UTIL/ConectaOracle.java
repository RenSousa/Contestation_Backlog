/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.sql.*;

/**
 *
 * @author RENAN.SOUSA
 */
public class ConectaOracle {

    public static Connection getConexaoOracle() throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        
        try {
 
        String driverName = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driverName);
        String serverName = "bredt1-clbddp07-scan.cgmp-osa.com.br";
        String serverPort = "1521";               
        String sid = "CGMP6R";
        String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + "/" + sid;

        String username = "renan_sousa";
        String password = "r332805n";
        
        conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection suceeded");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        return conn;
    }
}


