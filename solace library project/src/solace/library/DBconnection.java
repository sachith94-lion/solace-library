/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solace.library;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sachith
 */
public class DBconnection {
    public static Connection connect(){
        
        Connection conn = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/solacelibrary","root","");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return conn;
    }
}
