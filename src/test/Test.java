/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riad
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* Connexion à la base de données */
String url = "jdbc:mysql://localhost:3306/ecole";
String user = "root";
String password = "";
Connection connexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url,user, password);
             System.out.println("Connection etablis");
        } catch (ClassNotFoundException ex) {
            System.out.println("Le pilote jdbc introuvable");
            
        } catch (SQLException ex) {
            System.out.println("Les parametres de connnection sont invalide");
        }
    }
    
}
