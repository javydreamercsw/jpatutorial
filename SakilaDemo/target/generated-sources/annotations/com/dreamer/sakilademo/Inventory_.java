package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Film;
import com.dreamer.sakilademo.Rental;
import com.dreamer.sakilademo.Store;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Inventory.class)
public class Inventory_ { 

    public static volatile CollectionAttribute<Inventory, Rental> rentalCollection;
    public static volatile SingularAttribute<Inventory, Date> lastUpdate;
    public static volatile SingularAttribute<Inventory, Film> filmId;
    public static volatile SingularAttribute<Inventory, Integer> inventoryId;
    public static volatile SingularAttribute<Inventory, Store> storeId;

}