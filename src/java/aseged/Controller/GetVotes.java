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
@ManagedBean(name="VoteBean")
@RequestScoped
public class GetVotes {
    
    private int id;
    private String username;
    private String vote;
    private Date votedat;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     */
    public void setVote(String vote) {
        this.vote = vote;
    }

    /**
     *
     * @return
     */
    public Date getVotedat() {
        return votedat;
    }

    /**
     *
     * @param votedat
     */
    public void setVotedat(Date votedat) {
        this.votedat = votedat;
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
                String sql = "select * from vote";
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
