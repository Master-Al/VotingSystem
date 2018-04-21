/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ejave
 */
public class DatabaseConnection {
    
    private static Connection databaseConnection = null;

    /**
     * @return the databaseConnection
     */
    public static Connection getDatabaseConnection() {
        
        if(databaseConnection == null){
            try {
                databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shs_election?zeroDateTimeBehavior=convertToNulL","root","");
                //databaseConnection = DriverManager.getConnection("jdbc:mysql://192.168.0.234 :3306/shs_election?zeroDateTimeBehavior=convertToNull","root","");
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //System.out.println("Connected to database!");
        return databaseConnection;
    }
    
    
    public static int getStudentID(String idnumber){
        int id = 0;
        Connection c = getDatabaseConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT id FROM student WHERE idnumber = ?");
            ps.setString(1, idnumber);
            ResultSet rs = ps.executeQuery();
            
            id = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    
    
    
}
