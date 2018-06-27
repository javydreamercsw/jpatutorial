package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Film;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Language.class)
public class Language_ { 

    public static volatile SingularAttribute<Language, Date> lastUpdate;
    public static volatile CollectionAttribute<Language, Film> filmCollection;
    public static volatile SingularAttribute<Language, Short> languageId;
    public static volatile SingularAttribute<Language, String> name;
    public static volatile CollectionAttribute<Language, Film> filmCollection1;

}