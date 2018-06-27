package com.dreamer.sakilademo;

import com.dreamer.sakilademo.City;
import com.dreamer.sakilademo.Customer;
import com.dreamer.sakilademo.Staff;
import com.dreamer.sakilademo.Store;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile CollectionAttribute<Address, Store> storeCollection;
    public static volatile SingularAttribute<Address, String> address;
    public static volatile SingularAttribute<Address, String> address2;
    public static volatile SingularAttribute<Address, String> phone;
    public static volatile CollectionAttribute<Address, Customer> customerCollection;
    public static volatile SingularAttribute<Address, String> district;
    public static volatile SingularAttribute<Address, String> postalCode;
    public static volatile SingularAttribute<Address, Date> lastUpdate;
    public static volatile CollectionAttribute<Address, Staff> staffCollection;
    public static volatile SingularAttribute<Address, City> cityId;
    public static volatile SingularAttribute<Address, Short> addressId;

}