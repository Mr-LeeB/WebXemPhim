package com.bkmovieapplication.entity;

import com.bkmovieapplication.entity.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-06T00:05:25")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, String> cmtID;
    public static volatile SingularAttribute<Comment, Integer> star;
    public static volatile SingularAttribute<Comment, String> comment;
    public static volatile SingularAttribute<Comment, Movie> movieID;
    public static volatile SingularAttribute<Comment, Integer> userID;

}