/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Controller;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aseged
 */
@ManagedBean(name="Comments")
@RequestScoped 
public class displayComments implements Serializable{
    
    private String username;
    private String comment;
    private Date commentedat;

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
