/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bkmovieapplication.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "movie")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieId", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Movie.findByNameEnglish", query = "SELECT m FROM Movie m WHERE m.nameEnglish = :nameEnglish"),
    @NamedQuery(name = "Movie.findByNameVietnamese", query = "SELECT m FROM Movie m WHERE m.nameVietnamese = :nameVietnamese"),
    @NamedQuery(name = "Movie.findByMovieStar", query = "SELECT m FROM Movie m WHERE m.movieStar = :movieStar"),
    @NamedQuery(name = "Movie.findByReleaseDate", query = "SELECT m FROM Movie m WHERE m.releaseDate = :releaseDate"),
    @NamedQuery(name = "Movie.findByImagemax", query = "SELECT m FROM Movie m WHERE m.imagemax = :imagemax"),
    @NamedQuery(name = "Movie.findByImagemin", query = "SELECT m FROM Movie m WHERE m.imagemin = :imagemin"),
    @NamedQuery(name = "Movie.findBySpanList", query = "SELECT m FROM Movie m WHERE m.spanList = :spanList"),
    @NamedQuery(name = "Movie.findByCategory", query = "SELECT m FROM Movie m WHERE m.category = :category")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "movieId")
    private String movieId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nameEnglish")
    private String nameEnglish;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nameVietnamese")
    private String nameVietnamese;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "movieStar")
    private String movieStar;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "imagemax")
    private String imagemax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "imagemin")
    private String imagemin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "span_list")
    private String spanList;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "trailerLink")
    private String trailerLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "category")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieid")
    private Collection<Bookmarked> bookmarkedCollection;
    @OneToMany(mappedBy = "movieID")
    private Collection<Comment> commentCollection;

    public Movie() {
    }

    public Movie(String movieId) {
        this.movieId = movieId;
    }

    public Movie(String movieId, String nameEnglish, String nameVietnamese, String movieStar, Date releaseDate, String description, String imagemax, String imagemin, String spanList, String trailerLink, String category) {
        this.movieId = movieId;
        this.nameEnglish = nameEnglish;
        this.nameVietnamese = nameVietnamese;
        this.movieStar = movieStar;
        this.releaseDate = releaseDate;
        this.description = description;
        this.imagemax = imagemax;
        this.imagemin = imagemin;
        this.spanList = spanList;
        this.trailerLink = trailerLink;
        this.category = category;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getNameVietnamese() {
        return nameVietnamese;
    }

    public void setNameVietnamese(String nameVietnamese) {
        this.nameVietnamese = nameVietnamese;
    }

    public String getMovieStar() {
        return movieStar;
    }

    public void setMovieStar(String movieStar) {
        this.movieStar = movieStar;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagemax() {
        return imagemax;
    }

    public void setImagemax(String imagemax) {
        this.imagemax = imagemax;
    }

    public String getImagemin() {
        return imagemin;
    }

    public void setImagemin(String imagemin) {
        this.imagemin = imagemin;
    }

    public String getSpanList() {
        return spanList;
    }

    public void setSpanList(String spanList) {
        this.spanList = spanList;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Bookmarked> getBookmarkedCollection() {
        return bookmarkedCollection;
    }

    public void setBookmarkedCollection(Collection<Bookmarked> bookmarkedCollection) {
        this.bookmarkedCollection = bookmarkedCollection;
    }

    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bkmovieapplication.entity.Movie[ movieId=" + movieId + " ]";
    }
    
}
