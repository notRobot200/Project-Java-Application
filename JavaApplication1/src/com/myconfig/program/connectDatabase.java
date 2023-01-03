/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myconfig.program;

import java.net.Socket;
import java.sql.*;

/**
 *
 * @author muhammad7fold
 */
public class connectDatabase {
    Connection MySQLConfig;
    Statement statement;
    String SQL;
    String url;
    String username;
    String password;
    String client;
    int Port;
    String Host;
    
    public connectDatabase(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
        this.Host = Host;
        this.Port = Port;
    }
    public Connection connectDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            MySQLConfig = DriverManager.getConnection(url, username, password);
            
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return MySQLConfig;
    }
    public Connection closeConnect(){
        try{
            MySQLConfig.close();
        }catch(Exception e){
            
        }return MySQLConfig;
    }
     public ResultSet eksekusiQuery(String sql){
        connectDatabase();
        ResultSet resultSet=null;
        try{
            statement=MySQLConfig.createStatement();
            resultSet=statement.executeQuery(sql);
            System.out.println(sql);
        } catch (SQLException ex){
            
        }
        return resultSet;
    }
     public String eksekusiUpdate(String sql){
        connectDatabase();
        String result=" ";
            try{
                statement=MySQLConfig.createStatement();
                statement.executeUpdate(sql);
                System.out.println(sql);
            } catch (SQLException ex){
                result=ex.toString();
            }
            return result;
    }
}
