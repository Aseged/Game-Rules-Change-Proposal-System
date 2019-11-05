/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Beans;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Aseged
 * 
 * Here we create the getters and setters for comments table 
 */
@ManagedBean(name="commentBean")
@SessionScoped 
public class commentBean implements Serializable {
    private int commentid;
    private int id;
    private String username;
    private String comment;
    private Date commentedat;

    /**
     *
     * @return
     */
    public int getCommentid() {
        return commentid;
    }

    /**
     *
     * @param commentid
     */
    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

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
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public Date getCommentedat() {
        return commentedat;
    }

    /**
     *
     * @param commentedat
     */
    public void setCommentedat(Date commentedat) {
        this.commentedat = commentedat;
    }
    
    
}
