package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Address;
import com.dreamer.sakilademo.Country;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile CollectionAttribute<City, Address> addressCollection;
    public static volatile SingularAttribute<City, String> city;
    public static volatile SingularAttribute<City, Date> lastUpdate;
    public static volatile SingularAttribute<City, Short> cityId;
    public static volatile SingularAttribute<City, Country> countryId;

}