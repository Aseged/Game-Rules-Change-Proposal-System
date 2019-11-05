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
 * Here we create the getters and setters for proposal table 
 */
@ManagedBean(name="proposalBean")
@RequestScoped
public class proposalBean implements Serializable {
    private int id;
    private String title;
    private String description;
    private String justification;
    private String votestatus;
    private Date votedeadline;

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

    

    
}