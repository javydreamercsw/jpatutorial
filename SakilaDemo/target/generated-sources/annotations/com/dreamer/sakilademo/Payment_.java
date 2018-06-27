package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Customer;
import com.dreamer.sakilademo.Rental;
import com.dreamer.sakilademo.Staff;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, BigDecimal> amount;
    public static volatile SingularAttribute<Payment, Short> paymentId;
    public static volatile SingularAttribute<Payment, Date> lastUpdate;
    public static volatile SingularAttribute<Payment, Customer> customerId;
    public static volatile SingularAttribute<Payment, Date> paymentDate;
    public static volatile SingularAttribute<Payment, Staff> staffId;
    public static volatile SingularAttribute<Payment, Rental> rentalId;

}