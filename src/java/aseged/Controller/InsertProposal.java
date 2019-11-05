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
@ManagedBean(name="prInsertBean")
@SessionScoped
public class InsertProposal implements Serializable {

    private String title;
    private String description;
    private String justification;
    
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
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String checkProposalIn() throws ClassNotFoundException, SQLException{
       
        
           Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "insert into proposals (USERNAME, TITLE, DESCRIPTION, JUSTIFICATION, VOTESTATUS, PROPOSEDAT) VALUES ('userAdmin', '"+title+"', '"+description+"', '"+justification+"', 'Closed',  CURRENT_TIMESTAMP)";
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.executeUpdate();
            
     
        return "index.xhtml?faces-redirect=true";

    }
    
}
