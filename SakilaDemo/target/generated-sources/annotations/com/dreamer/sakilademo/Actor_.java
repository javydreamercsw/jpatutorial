package com.dreamer.sakilademo;

import com.dreamer.sakilademo.FilmActor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile SingularAttribute<Actor, String> firstName;
    public static volatile SingularAttribute<Actor, String> lastName;
    public static volatile CollectionAttribute<Actor, FilmActor> filmActorCollection;
    public static volatile SingularAttribute<Actor, Short> actorId;
    public static volatile SingularAttribute<Actor, Date> lastUpdate;

}