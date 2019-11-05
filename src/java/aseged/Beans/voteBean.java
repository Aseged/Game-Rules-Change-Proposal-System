/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Beans;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aseged
 * Here we create the getters and setters for vote table 
 */
@ManagedBean(name="voteBean")
@RequestScoped
public class voteBean implements Serializable {
    private int voteid;
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
    public int getVoteid() {
        return voteid;
    }

    /**
     *
     * @param voteid
     */
    public void setVoteid(int voteid) {
        this.voteid = voteid;
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
    
    
    
}
