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
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Aseged
 */
@ManagedBean(name="cmInsertBean")
@SessionScoped
public class InsertComment implements Serializable {
    
    private String comment;
    private String Id;
    private String username;

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
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(String Id) {
        this.Id = Id;
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
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String checkCommentIn() throws ClassNotFoundException, SQLException{
       
       // try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "insert into comments (ID, USERNAME,  COMMENT, COMMENTEDAT) VALUES (2, 'userAdmin', '"+comment+"', CURRENT_TIMESTAMP)";
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.executeUpdate();


        //}catch(Exception e){
        //e.printStackTrace();
       // }
            return "proposalDetail.xhtml?faces-redirect=true";
    }
           /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
      public List<displayComments> displayComments() throws ClassNotFoundException, SQLException {
        List<displayComments> list = new ArrayList<>();
        
        
        try{
              Connection con =null;
              PreparedStatement ps=null;
              ResultSet rs=null;
              
               Class.forName("org.apache.derby.jdbc.ClientDriver");
               con = DriverManager.getConnection("jdbc:derby://localhost:1527/WOLDESELASSIEA;create=true;user=WOLDESELASSIEA;password=WOLDESELASSIEA");
                String sql = "select comments.* from comments inner join proposals on comments.ID = proposals.ID " ;
                ps=con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()){
                    
                    displayComments P = new displayComments();
                    P.setComment(rs.getString("comment"));
                    P.setUsername(rs.getString("username"));
                    P.setCommentedat(rs.getDate("commentedat"));
                    list.add(P);

                }
        }catch(Exception e){
        e.printStackTrace();
        }        

             return list;        
        
    }
    
}
