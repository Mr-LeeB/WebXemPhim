/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkmovieapplication.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "comment")
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCmtID", query = "SELECT c FROM Comment c WHERE c.cmtID = :cmtID"),
    @NamedQuery(name = "Comment.findByComment", query = "SELECT c FROM Comment c WHERE c.comment = :comment"),
    @NamedQuery(name = "Comment.findByStar", query = "SELECT c FROM Comment c WHERE c.star = :star")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cmtID")
    private Integer cmtID;
    @Size(max = 1000)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "movieID", referencedColumnName = "movieId")
    @ManyToOne
    private String movieID;
    @JoinColumn(name = "userID", referencedColumnName = "userId")
    @ManyToOne
    private Integer userID;
    
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Comment() {
    }

    public Comment(Integer cmtID) {
        this.cmtID = cmtID;
    }
    
    public Comment(Integer cmtID,String movieID, Integer userID,  String comment, String userName){
        this.cmtID = cmtID;
        this.comment = comment;
        this.movieID = movieID;
        this.userID = userID;
        this.userName = userName;
    }

    public Integer getCmtID() {
        return cmtID;
    }

    public void setCmtID(Integer cmtID) {
        this.cmtID = cmtID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmtID != null ? cmtID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.cmtID == null && other.cmtID != null) || (this.cmtID != null && !this.cmtID.equals(other.cmtID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkmovieapplication.entity.Comment[ cmtID=" + cmtID + " ]";
    }
    
}
