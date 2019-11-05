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
@ManagedBean(name="ProposalBean")
@RequestScoped
public class Proposals implements Serializable {
    private String title;
    private Date proposedat;
    private String username;
    private String description;
    private String comments;
    private String status;
    private String votes;
    private String justification;
    private String votestatus;
    private Date votedeadline;

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Date getProposedat() {
        return proposedat;
    }

    /**
     *
     * @param proposedat
     */
    public void setProposedat(Date proposedat) {
        this.proposedat = proposedat;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getVotes() {
        return votes;
    }

    /**
     *
     * @param votes
     */
    public void setVotes(String votes) {
        this.votes = votes;
    }

    /**
     *
     * @return
     */
    public String getJustification() {
        return justification;
    }

    /**
     *
     * @param justification
     */
    public void setJustification(String justification) {
        this.justification = justification;
    }

    /**
     *
     * @return
     */
    public String getVotestatus() {
        return votestatus;
    }

    /**
     *
     * @param votestatus
     */
    public void setVotestatus(String votestatus) {
        this.votestatus = votestatus;
    }

    /**
     *
     * @return
     */
    public Date getVotedeadline() {
        return votedeadline;
    }

    /**
     *
     * @param votedeadline
     */
    public void setVotedeadline(Date votedeadline) {
        this.votedeadline = votedeadline;
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<Proposals> displayProposal() throws ClassNotFoundException, SQLException {
        List<Proposals> list = new ArrayList<>();
        
              Connection con =null;
              PreparedStatement ps=null;
              ResultSet rs=null;
              
               Class.forName("org.apache.derby.jdbc.ClientDriver");
               con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "select * from proposals";
                ps=con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()){
                    
                    Proposals P = new Proposals();
                    P.setTitle(rs.getString("title"));
                    P.setUsername(rs.getString("username"));
                    P.setDescription(rs.getString("description"));
                    P.setJustification(rs.getString("justification"));
                    P.setVotestatus(rs.getString("votestatus"));
                    P.setVotedeadline(rs.getDate("votedeadline"));
                    P.setProposedat(rs.getDate("proposedat"));
                    list.add(P);

                }
                

             return list;        
        
    }

    
}
