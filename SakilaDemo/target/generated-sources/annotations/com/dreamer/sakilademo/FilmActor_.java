package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Actor;
import com.dreamer.sakilademo.Film;
import com.dreamer.sakilademo.FilmActorPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(FilmActor.class)
public class FilmActor_ { 

    public static volatile SingularAttribute<FilmActor, Actor> actor;
    public static volatile SingularAttribute<FilmActor, FilmActorPK> filmActorPK;
    public static volatile SingularAttribute<FilmActor, Date> lastUpdate;
    public static volatile SingularAttribute<FilmActor, Film> film;

}