/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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
             Statement state= connexion.createStatement();
             ResultSet result= state.executeQuery("SELECT * FROM etudiant");
             ResultSetMetaData  metaData = result.getMetaData();
             System.out.println("---------------------------------------------------------");
             for(int i=1;i<=metaData.getColumnCount();i++){
                 System.out.print("\t"+metaData.getColumnName(i)+"\t|");
             }
            System.out.println("\n---------------------------------------------------");
            while(result.next()){
             for(int i=1;i<=metaData.getColumnCount();i++){
                 System.out.print("\t"+result.getObject(i)+"\t|");
             }
             System.out.println("\n-------------------------------------------------------");
            }
             result.close();
             state.close();   
             connexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Le pilote jdbc introuvable");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Les parametres de connnection sont invalide");
        }
    }
    
}
