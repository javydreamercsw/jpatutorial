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
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile CollectionAttribute<Customer, Rental> rentalCollection;
    public static volatile SingularAttribute<Customer, Date> lastUpdate;
    public static volatile SingularAttribute<Customer, Short> customerId;
    public static volatile SingularAttribute<Customer, Boolean> active;
    public static volatile SingularAttribute<Customer, Store> storeId;
    public static volatile CollectionAttribute<Customer, Payment> paymentCollection;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, Date> createDate;
    public static volatile SingularAttribute<Customer, Address> addressId;

}