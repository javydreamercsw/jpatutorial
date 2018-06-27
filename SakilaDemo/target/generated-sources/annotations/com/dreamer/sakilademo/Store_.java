package com.dreamer.sakilademo;

import com.dreamer.sakilademo.Address;
import com.dreamer.sakilademo.Customer;
import com.dreamer.sakilademo.Inventory;
import com.dreamer.sakilademo.Staff;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.2.v20180622-rNA", date="2018-06-27T13:35:55")
@StaticMetamodel(Store.class)
public class Store_ { 

    public static volatile CollectionAttribute<Store, Customer> customerCollection;
    public static volatile CollectionAttribute<Store, Inventory> inventoryCollection;
    public static volatile SingularAttribute<Store, Date> lastUpdate;
    public static volatile CollectionAttribute<Store, Staff> staffCollection;
    public static volatile SingularAttribute<Store, Short> storeId;
    public static volatile SingularAttribute<Store, Address> addressId;
    public static volatile SingularAttribute<Store, Staff> managerStaffId;

}