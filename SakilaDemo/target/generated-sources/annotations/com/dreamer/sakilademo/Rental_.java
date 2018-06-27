package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Customer;
import com.dreamer.sakilademo.Inventory;
import com.dreamer.sakilademo.Payment;
import com.dreamer.sakilademo.Staff;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Rental.class)
public class Rental_ { 

    public static volatile SingularAttribute<Rental, Date> rentalDate;
    public static volatile SingularAttribute<Rental, Date> returnDate;
    public static volatile SingularAttribute<Rental, Date> lastUpdate;
    public static volatile SingularAttribute<Rental, Customer> customerId;
    public static volatile SingularAttribute<Rental, Inventory> inventoryId;
    public static volatile CollectionAttribute<Rental, Payment> paymentCollection;
    public static volatile SingularAttribute<Rental, Staff> staffId;
    public static volatile SingularAttribute<Rental, Integer> rentalId;

}