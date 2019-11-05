/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Controller;


import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Aseged
 * This controller allows users to register. 
 * It creates a connection to the server as opposed to using the facades.
 */
@ManagedBean(name="regBean")
@SessionScoped
public class registerController implements Serializable {
   
    //code from primefaces
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private Map<String,String> countries;
    private Map<String,String> roles;    
    private String[] selectedConsoles;
    private String fullname;
    private String username;
    private String password;
    private String email;
    
    /**
     *
     */
    @PostConstruct
        public void init() {
            countries  = new HashMap<String, String>();
            countries.put("USA", "USA");
            countries.put("Germany", "Germany");
            countries.put("Brazil", "Brazil");
            countries.put("UK", "UK");

            roles  = new HashMap<String, String>();
            roles.put("Unconfirmed", "Unconfirmed");
            roles.put("Approved", "Administrator");
            roles.put("Commenter", "Administrator");
            roles.put("Voter", "Administrator");   
            roles.put("Administrator", "Administrator"); 
        }

    /**
     *
     * @return
     */
    public Map<String, Map<String, String>> getData() {
        return data;
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
    public String[] getSelectedConsoles() {
        return selectedConsoles;
    }

    /**
     *
     * @param selectedConsoles
     */
    public void setSelectedConsoles(String[] selectedConsoles) {
        this.selectedConsoles = selectedConsoles;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getCountries() {
        return countries;
    }

    /**
     *
     * @param countries
     */
    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public Map<String, String> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, String> roles) {
        this.roles = roles;
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
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String regUser() throws ClassNotFoundException, SQLException{
       
        
           Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "insert into users (USERNAME,  PASSWORD, FULLNAME, EMAIL, COUNTRY, ROLES, STATUS, JOINED) VALUES ('"+username+"', '"+password+"', '"+fullname+"', '"+email+"', '"+country+"', 'Unconfirmed', '"+Arrays.toString(selectedConsoles)+"', CURRENT_TIMESTAMP)";
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.executeUpdate();
            
     
        return "regThankYou.xhtml?faces-redirect=true";

    }
}
