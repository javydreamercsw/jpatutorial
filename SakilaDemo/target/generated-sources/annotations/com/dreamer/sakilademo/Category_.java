package com.dreamer.sakilademo;

import com.dreamer.sakilademo.FilmCategory;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile CollectionAttribute<Category, FilmCategory> filmCategoryCollection;
    public static volatile SingularAttribute<Category, Date> lastUpdate;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Short> categoryId;

}