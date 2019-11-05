/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aseged.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aseged
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByFullname", query = "SELECT u FROM Users u WHERE u.fullname = :fullname")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByCountry", query = "SELECT u FROM Users u WHERE u.country = :country")
    , @NamedQuery(name = "Users.findByRoles", query = "SELECT u FROM Users u WHERE u.roles = :roles")
    , @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status")
    , @NamedQuery(name = "Users.findByLastlog", query = "SELECT u FROM Users u WHERE u.lastlog = :lastlog")
    , @NamedQuery(name = "Users.findByJoined", query = "SELECT u FROM Users u WHERE u.joined = :joined")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FULLNAME")
    private String fullname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ROLES")
    private String roles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LASTLOG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOINED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Proposals> proposalsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Vote> voteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Comments> commentsCollection;

    /**
     *
     */
    public Users() {
    }

    /**
     *
     * @param username
     */
    public Users(String username) {
        this.username = username;
    }

    /**
     *
     * @param username
     * @param password
     * @param fullname
     * @param email
     * @param country
     * @param roles
     * @param status
     * @param joined
     */
    public Users(String username, String password, String fullname, String email, String country, String roles, String status, Date joined) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.country = country;
        this.roles = roles;
        this.status = status;
        this.joined = joined;
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

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Proposals> getProposalsCollection() {
        return proposalsCollection;
    }

    /**
     *
     * @param proposalsCollection
     */
    public void setProposalsCollection(Collection<Proposals> proposalsCollection) {
        this.proposalsCollection = proposalsCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    /**
     *
     * @param voteCollection
     */
    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    /**
     *
     * @param commentsCollection
     */
    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aseged.Entities.Users[ username=" + username + " ]";
    }
    
}
