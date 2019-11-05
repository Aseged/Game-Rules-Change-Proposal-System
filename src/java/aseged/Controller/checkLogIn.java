/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Aseged
 * use the connection to log users.
 */
class checkLogIn {
    
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean logCheckin (String username, String password) throws ClassNotFoundException, SQLException{
                              
              Connection con =null;
              PreparedStatement ps=null;
              ResultSet rs=null;
              
               Class.forName("org.apache.derby.jdbc.ClientDriver");
               con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = ("SELECT username, password FROM users WHERE username = ? AND password = ?");
                ps=con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if(rs.next()){
                   return true; 
                }
                return false;

                

    } 


    
}
