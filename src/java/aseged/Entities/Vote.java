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
@Table(name = "VOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v")
    , @NamedQuery(name = "Vote.findByVoteid", query = "SELECT v FROM Vote v WHERE v.voteid = :voteid")
    , @NamedQuery(name = "Vote.findByVote", query = "SELECT v FROM Vote v WHERE v.vote = :vote")
    , @NamedQuery(name = "Vote.findByVotedat", query = "SELECT v FROM Vote v WHERE v.votedat = :votedat")})
public class Vote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VOTEID")
    private Integer voteid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "VOTE")
    private String vote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOTEDAT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date votedat;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proposals id;
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Users username;

    /**
     *
     */
    public Vote() {
    }

    /**
     *
     * @param voteid
     */
    public Vote(Integer voteid) {
        this.voteid = voteid;
    }

    /**
     *
     * @param voteid
     * @param vote
     * @param votedat
     */
    public Vote(Integer voteid, String vote, Date votedat) {
        this.voteid = voteid;
        this.vote = vote;
        this.votedat = votedat;
    }

    /**
     *
     * @return
     */
    public Integer getVoteid() {
        return voteid;
    }

    /**
     *
     * @param voteid
     */
    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    /**
     *
     * @return
     */
    public String getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     */
    public void setVote(String vote) {
        this.vote = vote;
    }

    /**
     *
     * @return
     */
    public Date getVotedat() {
        return votedat;
    }

    /**
     *
     * @param votedat
     */
    public void setVotedat(Date votedat) {
        this.votedat = votedat;
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
        hash += (voteid != null ? voteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.voteid == null && other.voteid != null) || (this.voteid != null && !this.voteid.equals(other.voteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aseged.Entities.Vote[ voteid=" + voteid + " ]";
    }
    
}
