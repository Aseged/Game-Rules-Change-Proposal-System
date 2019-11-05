/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Controller;


import aseged.Beans.commentBean;
import aseged.Beans.proposalBean;
import aseged.Beans.userBean;
import aseged.Beans.voteBean;
import aseged.Entities.Comments;
import aseged.Entities.Proposals;
import aseged.Entities.Users;
import aseged.Entities.Vote;
import aseged.Facade.CommentsFacade;
import aseged.Facade.ProposalsFacade;
import aseged.Facade.UsersFacade;
import aseged.Facade.VoteFacade;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.beans.Beans;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Aseged
 * This is the main controller that connects to the main facade 
 * It also calls the CRUD operation for all tables
 */

@ManagedBean(name="ViewEditController")
@SessionScoped
public class ViewEditController implements Serializable{

    private Proposals p = new Proposals();
    private Comments c = new Comments();
    private Users u = new Users();
    
    
    @EJB
    private ProposalsFacade proposalsFacade;
    @EJB
    private CommentsFacade commentsFacade;
    @EJB
    private VoteFacade voteFacade;
    @EJB
    private UsersFacade UsersFacade;
    @Inject
    aseged.Beans.userBean userBean;
    @Inject
    aseged.Beans.proposalBean proposalBean;
    @Inject
    aseged.Beans.commentBean commentBean;
    @Inject
    aseged.Beans.voteBean voteBean;

    public Proposals getP() {
        return p;
    }

    public void setP(Proposals p) {
        this.p = p;
    }

    public Comments getC() {
        return c;
    }

    public void setC(Comments c) {
        this.c = c;
    }

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }

    public ProposalsFacade getProposalsFacade() {
        return proposalsFacade;
    }

    public void setProposalsFacade(ProposalsFacade proposalsFacade) {
        this.proposalsFacade = proposalsFacade;
    }

    public CommentsFacade getCommentsFacade() {
        return commentsFacade;
    }

    public void setCommentsFacade(CommentsFacade commentsFacade) {
        this.commentsFacade = commentsFacade;
    }

    public VoteFacade getVoteFacade() {
        return voteFacade;
    }

    public void setVoteFacade(VoteFacade voteFacade) {
        this.voteFacade = voteFacade;
    }

    public UsersFacade getUsersFacade() {
        return UsersFacade;
    }

    public void setUsersFacade(UsersFacade UsersFacade) {
        this.UsersFacade = UsersFacade;
    }

    public userBean getUserBean() {
        return userBean;
    }

    public void setUserBean(userBean userBean) {
        this.userBean = userBean;
    }

    public proposalBean getProposalBean() {
        return proposalBean;
    }

    public void setProposalBean(proposalBean proposalBean) {
        this.proposalBean = proposalBean;
    }

    public commentBean getCommentBean() {
        return commentBean;
    }

    public void setCommentBean(commentBean commentBean) {
        this.commentBean = commentBean;
    }

    public voteBean getVoteBean() {
        return voteBean;
    }

    public void setVoteBean(voteBean voteBean) {
        this.voteBean = voteBean;
    }

    
/**
 *
 * Find all records
     * @return 
 */
    public List<Proposals> findAllProposals(){
         return this.proposalsFacade.findAll();
    }
   
    /**
     *
     * @return
     */
    public List<Comments> findAllComments(){
        return this.commentsFacade.findAll();
    }
    
    /**
     *
     * @return
     */
    public List<Vote> findAllVotes(){
        return this.voteFacade.findAll();
    }

    /**
     *
     * @return
     */
    public List<Users> findAllUsers(){
        return this.UsersFacade.findAll();
    }
    /**
 *
 * Count all records
     * @return 
 */
    public int usersCount() {
        return UsersFacade.count();
    } 
        
    /**
     *
     * @return
     */
    public int proposalsCount() {
        return proposalsFacade.count();
    }
    
    /**
     *
     * @return
     */
    public int commentCount() {
        return commentsFacade.count();
    }
    
    /**
     *
     * @return
     */
    public int voteCount(){
        return voteFacade.count();
    }
 /**
 *
 * Delete records
     * @param p
     * @return 
 */
 public String deleteProposal(Proposals p){
     
     proposalsFacade.remove(p);
     return null;
     
 }
 
    /**
     *
     * @param u
     * @return
     */
    public String deleteUser(Users u){
     
     UsersFacade.remove(u);
     return null;
     
 }

    /**
     *
     * @param c
     * @return
     */
    public String deleteComment(Comments c){
     
     commentsFacade.remove(c);
     return null;
     
 }

    /**
     *
     * @param v
     * @return
     */
    public String deleteVote(Vote v){
     
     voteFacade.remove(v);
     return null;
     
 }
    
 public String editUser(Users u){
     this.u = u;
     return "updateUser";
 }   
 
  public String editUser(){
     this.UsersFacade.edit(this.u);
     return "viewUsers";
 }  
  
 public String editProposal(Proposals p){
     
     this.p = p;
     return "updateProposal";
 }
 public String editProposal(){
     this.proposalsFacade.edit(this.p);
     return "index";
 }

 
 /**
 *
 * Edit records
     * @param u
     * @return 
 */
  /* 
  public String editUsers(Users u){
 
    userBean.setUsername(u.getUsername());
    userBean.setPassword(u.getPassword());
    userBean.setFullname(u.getFullname());
    userBean.setEmail(u.getEmail());
    userBean.setCountry(u.getCountry());
    userBean.setRoles(u.getRoles());
    userBean.setStatus(u.getStatus());
    userBean.setLastlog(u.getLastlog());
    userBean.setJoined(u.getJoined());


      return "updateUser";
 }

    /**
     *
     * @param p
     * @return
     */
 /*
    public String editProposal(Proposals p){
    
    proposalBean.setId(p.getId());
    proposalBean.setTitle(p.getTitle());
    proposalBean.setDescription(p.getDescription());
    proposalBean.setJustification(p.getJustification());
    proposalBean.setVotestatus(p.getVotestatus());
    proposalBean.setVotedeadline(p.getVotedeadline());
       
      return "updateProposal";
 } 
*/
    /**
     *
     * @param c
     * @return
     */
    /*
    public String editComments(Comments c){

    commentBean.setComment(c.getComment());    
      return "updateComment";
 } */
    
  public String editComments(Comments c){
     this.c = c;
     return "updateComment";
  }
    public String editComments(){
     this.commentsFacade.edit(this.c);
     return "proposalDetail";
  }
  
 
  /**
 *
 * Save changes in record
     * @return 
 */
   /* 
  public String saveUser(){
     
      Users u = new Users(userBean.getUsername());
      u.setUsername(userBean.getUsername());
      u.setPassword(userBean.getPassword());
      u.setFullname(userBean.getFullname());
      u.setEmail(userBean.getEmail());
      u.setCountry(userBean.getCountry());
      u.setRoles(userBean.getRoles());
      u.setStatus(userBean.getStatus());
      u.setLastlog(userBean.getLastlog());
      u.setJoined(userBean.getJoined());
      
      UsersFacade.edit(u);
      return "viewUsers.xhtml?faces-redirect=true";
 }  
  
    /**
     *
     * @return
     */
    public String saveProposal(){
     
      Proposals p = new Proposals(proposalBean.getId());
      p.setTitle(proposalBean.getTitle());
      p.setDescription(proposalBean.getDescription());
      p.setJustification(proposalBean.getJustification());
      p.setVotestatus(proposalBean.getVotestatus());
      p.setVotedeadline(proposalBean.getVotedeadline());
      
      proposalsFacade.edit(p);
      return "index";
 } 
   
    /**
     *
     * @return
     */
    public String saveComment(){
     
    Comments c = new Comments(commentBean.getCommentid());
    c.setComment(commentBean.getComment());
    
    commentsFacade.edit(c);

      return "proposalDetail";
 } 
 
  
}
