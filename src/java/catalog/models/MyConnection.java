/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author zakaria_afir
 * This class use the Singleton Pattern
 */
public class MyConnection {
    private static Connection connect;
    private String url = "jdbc:postgresql://localhost:5432/catalog";
    private String user = "admin";
    private String password = "catalog";
    
    private MyConnection(){
        try{
            connect = DriverManager.getConnection(url, user, password);
        }catch(SQLException ex){
             ex.printStackTrace(); 
        }
    }
    
    //Return the instance or ceate if it doesn’t exist 
    public static Connection getInstance(){ 
     if(connect == null){ 
       new MyConnection(); 
     } 
     return connect;    
   }    
}
