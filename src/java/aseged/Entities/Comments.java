/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aseged
 */
@Entity
@Table(name = "COMMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c")
    , @NamedQuery(name = "Comments.findByCommentid", query = "SELECT c FROM Comments c WHERE c.commentid = :commentid")
    , @NamedQuery(name = "Comments.findByComment", query = "SELECT c FROM Comments c WHERE c.comment = :comment")
    , @NamedQuery(name = "Comments.findByCommentedat", query = "SELECT c FROM Comments c WHERE c.commentedat = :commentedat")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COMMENTID")
    private Integer commentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "COMMENT")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMENTEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentedat;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proposals id;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Users username;

    /**
     *
     */
    public Comments() {
    }

    /**
     *
     * @param commentid
     */
    public Comments(Integer commentid) {
        this.commentid = commentid;
    }

    /**
     *
     * @param commentid
     * @param comment
     * @param commentedat
     */
    public Comments(Integer commentid, String comment, Date commentedat) {
        this.commentid = commentid;
        this.comment = comment;
        this.commentedat = commentedat;
    }

    /**
     *
     * @return
     */
    public Integer getCommentid() {
        return commentid;
    }

    /**
     *
     * @param commentid
     */
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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

    /**
     *
     * @return
     */
    public Proposals getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Proposals id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Users getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(Users username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentid != null ? commentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.commentid == null && other.commentid != null) || (this.commentid != null && !this.commentid.equals(other.commentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aseged.Entities.Comments[ commentid=" + commentid + " ]";
    }
    
}
