/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import java.sql.*;

public class ConectaBanco {
      
    public static Connection getConexao() throws SQLException {
        
        Connection c = null;
        
        try{
            //DRIVER QUE SERÁ UTILIZADO
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection("jdbc:sqlserver://BREDT1-CLBDDP10;databaseName=CANT;integratedSecurity=true;authenticationScheme=NativeAuthentication");

        }catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!"+e);
        }
        
        String catalog = c.getCatalog();
        System.out.println(catalog);
        
        return c;
        }
            

}
