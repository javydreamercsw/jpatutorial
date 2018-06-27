package com.dreamer.sakilademo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-27T13:28:05")
@StaticMetamodel(FilmList.class)
public class FilmList_ { 

    public static volatile SingularAttribute<FilmList, Short> fid;
    public static volatile SingularAttribute<FilmList, String> actors;
    public static volatile SingularAttribute<FilmList, BigDecimal> price;
    public static volatile SingularAttribute<FilmList, Short> length;
    public static volatile SingularAttribute<FilmList, String> rating;
    public static volatile SingularAttribute<FilmList, String> description;
    public static volatile SingularAttribute<FilmList, String> title;
    public static volatile SingularAttribute<FilmList, String> category;

}