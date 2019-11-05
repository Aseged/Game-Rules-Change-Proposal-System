/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aseged
 */
@ManagedBean (name="voteBean")
@SessionScoped
public class voteController implements Serializable{
    
    private int id;
    private String username;
    private String vote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
    
    
     /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */   
    
    public String userVote() throws ClassNotFoundException, SQLException{
       
        
           Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "insert into vote (ID, USERNAME,  VOTE, VOTEDAT) VALUES (1, 'userAdmin', '"+vote+"', CURRENT_TIMESTAMP)";
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.executeUpdate();
            
     
        return "viewVotes.xhtml?faces-redirect=true";

    }    
    
}
