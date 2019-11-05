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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROPOSALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposals.findAll", query = "SELECT p FROM Proposals p")
    , @NamedQuery(name = "Proposals.findById", query = "SELECT p FROM Proposals p WHERE p.id = :id")
    , @NamedQuery(name = "Proposals.findByTitle", query = "SELECT p FROM Proposals p WHERE p.title = :title")
    , @NamedQuery(name = "Proposals.findByDescription", query = "SELECT p FROM Proposals p WHERE p.description = :description")
    , @NamedQuery(name = "Proposals.findByJustification", query = "SELECT p FROM Proposals p WHERE p.justification = :justification")
    , @NamedQuery(name = "Proposals.findByVotestatus", query = "SELECT p FROM Proposals p WHERE p.votestatus = :votestatus")
    , @NamedQuery(name = "Proposals.findByVotedeadline", query = "SELECT p FROM Proposals p WHERE p.votedeadline = :votedeadline")
    , @NamedQuery(name = "Proposals.findByProposedat", query = "SELECT p FROM Proposals p WHERE p.proposedat = :proposedat")})
public class Proposals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "JUSTIFICATION")
    private String justification;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "VOTESTATUS")
    private String votestatus;
    @Column(name = "VOTEDEADLINE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date votedeadline;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPOSEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proposedat;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Users username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch=FetchType.EAGER)
    private Collection<Vote> voteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch=FetchType.EAGER)
    private Collection<Comments> commentsCollection;

    /**
     *
     */
    public Proposals() {
    }

    /**
     *
     * @param id
     */
    public Proposals(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param title
     * @param description
     * @param justification
     * @param votestatus
     * @param proposedat
     */
    public Proposals(Integer id, String title, String description, String justification, String votestatus, Date proposedat) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.justification = justification;
        this.votestatus = votestatus;
        this.proposedat = proposedat;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     */
    public String getVotestatus() {
        return votestatus;
    }

    /**
     *
     * @param votestatus
     */
    public void setVotestatus(String votestatus) {
        this.votestatus = votestatus;
    }

    /**
     *
     * @return
     */
    public Date getVotedeadline() {
        return votedeadline;
    }

    /**
     *
     * @param votedeadline
     */
    public void setVotedeadline(Date votedeadline) {
        this.votedeadline = votedeadline;
    }

    /**
     *
     * @return
     */
    public Date getProposedat() {
        return proposedat;
    }

    /**
     *
     * @param proposedat
     */
    public void setProposedat(Date proposedat) {
        this.proposedat = proposedat;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposals)) {
            return false;
        }
        Proposals other = (Proposals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aseged.Entities.Proposals[ id=" + id + " ]";
    }
    
}
