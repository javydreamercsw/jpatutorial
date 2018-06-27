package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Address;
import com.dreamer.sakilademo.Payment;
import com.dreamer.sakilademo.Rental;
import com.dreamer.sakilademo.Store;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile SingularAttribute<Staff, String> lastName;
    public static volatile CollectionAttribute<Staff, Rental> rentalCollection;
    public static volatile SingularAttribute<Staff, Boolean> active;
    public static volatile SingularAttribute<Staff, Store> store;
    public static volatile SingularAttribute<Staff, Store> storeId;
    public static volatile CollectionAttribute<Staff, Payment> paymentCollection;
    public static volatile SingularAttribute<Staff, byte[]> picture;
    public static volatile SingularAttribute<Staff, Address> addressId;
    public static volatile SingularAttribute<Staff, String> firstName;
    public static volatile SingularAttribute<Staff, String> password;
    public static volatile SingularAttribute<Staff, Date> lastUpdate;
    public static volatile SingularAttribute<Staff, Short> staffId;
    public static volatile SingularAttribute<Staff, String> email;
    public static volatile SingularAttribute<Staff, String> username;

}