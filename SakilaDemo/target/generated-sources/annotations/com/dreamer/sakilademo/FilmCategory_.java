package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Category;
import com.dreamer.sakilademo.Film;
import com.dreamer.sakilademo.FilmCategoryPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(FilmCategory.class)
public class FilmCategory_ { 

    public static volatile SingularAttribute<FilmCategory, Date> lastUpdate;
    public static volatile SingularAttribute<FilmCategory, FilmCategoryPK> filmCategoryPK;
    public static volatile SingularAttribute<FilmCategory, Film> film;
    public static volatile SingularAttribute<FilmCategory, Category> category;

}