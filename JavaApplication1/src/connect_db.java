/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muhammad7fold
 */
public class connect_db {
    private static Connection MySQLConfig;
    
    public static Connection configDB(){
        if(MySQLConfig == null){
        try{
            String url = "jdbc.mysql://localhost:8111/log_db";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Driver ditemukan");
        }catch(SQLException e){
            System.out.println("Koneksi ke Database gagal " + e.getMessage());
        }
    }
        return MySQLConfig;
    }

    static Connection getconnnect_db() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
