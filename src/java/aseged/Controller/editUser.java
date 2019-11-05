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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aseged
 */
@ManagedBean(name="usersBean")
@RequestScoped
public class editUser {
    
    /**
     *
     * @return
     */
    public List<editUser> displayUsers() {
     List<editUser> list = new ArrayList<>();
     
     return list;
 }
    
    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<GetVotes> displayVotes() throws ClassNotFoundException, SQLException {
        List<GetVotes> list = new ArrayList<>();
        
              Connection con =null;
              PreparedStatement ps=null;
              ResultSet rs=null;
              
               Class.forName("org.apache.derby.jdbc.ClientDriver");
               con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "select * from users";
                ps=con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()){
                    
                    GetVotes v = new GetVotes();
                    v.setId(rs.getInt("id"));
                    v.setUsername(rs.getString("username"));
                    v.setVote(rs.getString("vote"));
                    v.setVotedat(rs.getDate("votedat"));
                    list.add(v);

                }
                

             return list;        
        
    }
    
}
