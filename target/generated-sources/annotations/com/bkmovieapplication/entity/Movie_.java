package com.bkmovieapplication.entity;

import com.bkmovieapplication.entity.Bookmarked;
import com.bkmovieapplication.entity.Comment;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T07:39:55")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, Date> releaseDate;
    public static volatile CollectionAttribute<Movie, Comment> commentCollection;
    public static volatile SingularAttribute<Movie, String> description;
    public static volatile SingularAttribute<Movie, String> movieId;
    public static volatile SingularAttribute<Movie, String> movieStar;
    public static volatile SingularAttribute<Movie, String> imagemax;
    public static volatile SingularAttribute<Movie, String> trailerLink;
    public static volatile SingularAttribute<Movie, String> spanList;
    public static volatile SingularAttribute<Movie, String> imagemin;
    public static volatile SingularAttribute<Movie, String> nameEnglish;
    public static volatile SingularAttribute<Movie, String> nameVietnamese;
    public static volatile SingularAttribute<Movie, String> category;
    public static volatile CollectionAttribute<Movie, Bookmarked> bookmarkedCollection;

}