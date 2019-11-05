/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Aseged
 * Here we create the getters and setters for users table 
 */
@ManagedBean(name="userBean")
@SessionScoped
public class userBean implements Serializable{
    
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String country;
    private String roles;
    private String status;
    private String[] selectedConsoles;
    private Date lastlog;
    private Date joined;

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
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     *
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     *
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }

    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }

 

    /**
     *
     * @return
     */
    public Date getLastlog() {
        return lastlog;
    }

    /**
     *
     * @param lastlog
     */
    public void setLastlog(Date lastlog) {
        this.lastlog = lastlog;
    }

    /**
     *
     * @return
     */
    public Date getJoined() {
        return joined;
    }

    /**
     *
     * @param joined
     */
    public void setJoined(Date joined) {
        this.joined = joined;
    }
    
   
        public String updateUser() throws ClassNotFoundException, SQLException{
       
        
           Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "UPDATE users SET PASSWORD = '"+password+"', FULLNAME  = '"+fullname+"', EMAIL = '"+email+"', COUNTRY = '"+country+"', ROLES = 'Unconfirmed', STATUS = '"+Arrays.toString(selectedConsoles)+"' WHERE username = '"+username+"'";
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.executeUpdate();
            
     
        return "viewUsers.xhtml?faces-redirect=true";

    } 
    

}
