/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Controller;

import static aseged.Entities.Users_.password;
import static aseged.Entities.Users_.username;
import aseged.Facade.CommentsFacade;
import aseged.Facade.ProposalsFacade;
import aseged.Facade.UsersFacade;
import aseged.Facade.VoteFacade;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author Aseged
 */
@ManagedBean(name="logBean")
@SessionScoped
public class UserController implements Serializable{
    
   private  final checkLogIn check = new checkLogIn(); 
   
   
   private String username;
    private String password;
    

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
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
     * @param password
     */
   public void setPassword(String password) {
        this.password = password;
    }
    
        public String checkUserLog() throws ClassNotFoundException, SQLException {
       
        if (check.logCheckin(username, password)){
                return "index.xhtml?faces-redirect=true";
        }
        return "login.xhtml?faces-redirect=true";

    }



}
