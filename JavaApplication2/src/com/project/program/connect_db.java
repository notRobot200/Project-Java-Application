package com.project.program;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author muhammad7fold
 */
public class connect_db {
    private static Connection MySQLConfig;
    
    public static Connection configDB(){
        if(MySQLConfig == null){
        try{
            String url = "jdbc:mysql://localhost:8111/log_db";
            String user = "root";
            String pass = "";
            
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
            System.out.println("Driver ditemukan");
        }catch(SQLException e){
            System.out.println("Koneksi ke Database gagal " + e.getMessage());
        }
    }
        return MySQLConfig;
    }

    public connect_db(String HOST_DB, String USERNAME_DB, String PASSWORD_DB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ResultSet eksekusiQuery(String sql) {
        configDB();
        ResultSet resultSet = null;
       

            try {
                Statement statement = MySQLConfig.createStatement();
                resultSet = statement.executeQuery(sql);
                System.out.println(sql);
            } catch (SQLException ex) {
            }
       
        return resultSet;

    }
    //Fungsi untuk eksekusi query select semua kolom
    public ResultSet querySelectAll(String namaTabel) {

        String SQL = "SELECT * FROM " + namaTabel;
        return this.eksekusiQuery(SQL);

    }

//Overload fungsi untuk eksekusi query select semua kolom dengan where
    public ResultSet querySelectAll(String namaTabel, String kondisi) {

        String SQL = "SELECT * FROM " + namaTabel + " WHERE " + kondisi;
        return this.eksekusiQuery(SQL);

    }
    
}
