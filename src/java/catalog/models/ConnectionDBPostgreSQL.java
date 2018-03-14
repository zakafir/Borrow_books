/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalog.models;

import java.sql.Connection;
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger;
import java.sql.DriverManager; 
/**
 *
 * @author zakaria_afir
 */
public class ConnectionDBPostgreSQL {

    /**
     * URL de connection
     */
    private static String url = "jdbc:postgresql://localhost:5432/catalog";
    private static String user = "nopw";
    private static String passwd = "test";

    /**
     * Objet Connection
     */
    private static Connection connect;

    /**
     * Méthode d’accès à l’instance unique du singleton
     *
     * @return connect l’instance de la connection
     */
    public static Connection getInstance() {
        if (connect == null) {

            try {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConnectionDBPostgreSQL.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                connect = DriverManager.getConnection(url, user,
                        passwd);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("connexion erreur");
            }
        }
        return connect;
    }
}
