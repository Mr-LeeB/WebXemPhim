package com.bkmovieapplication.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-12-14T06:43:59")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> cmtID;
    public static volatile SingularAttribute<Comment, String> comment;
    public static volatile SingularAttribute<Comment, String> movieID;
    public static volatile SingularAttribute<Comment, String> userName;
    public static volatile SingularAttribute<Comment, Integer> userID;

}