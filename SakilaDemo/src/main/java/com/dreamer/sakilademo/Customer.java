/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.dreamer.sakilademo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
@Entity
@Table(name = "customer")
@NamedQueries(
{
  @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
  @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
  @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
  @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
  @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
  @NamedQuery(name = "Customer.findByActive", query = "SELECT c FROM Customer c WHERE c.active = :active"),
  @NamedQuery(name = "Customer.findByCreateDate", query = "SELECT c FROM Customer c WHERE c.createDate = :createDate"),
  @NamedQuery(name = "Customer.findByLastUpdate", query = "SELECT c FROM Customer c WHERE c.lastUpdate = :lastUpdate")
})
public class Customer implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "customer_id")
  private Short customerId;
  @Basic(optional = false)
  @Column(name = "first_name")
  private String firstName;
  @Basic(optional = false)
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "email")
  private String email;
  @Basic(optional = false)
  @Column(name = "active")
  private boolean active;
  @Basic(optional = false)
  @Column(name = "create_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
  private Collection<Rental> rentalCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
  private Collection<Payment> paymentCollection;
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  @ManyToOne(optional = false)
  private Address addressId;
  @JoinColumn(name = "store_id", referencedColumnName = "store_id")
  @ManyToOne(optional = false)
  private Store storeId;

  public Customer()
  {
  }

  public Customer(Short customerId)
  {
    this.customerId = customerId;
  }

  public Customer(Short customerId, String firstName, String lastName, boolean active, Date createDate)
  {
    this.customerId = customerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.active = active;
    this.createDate = createDate;
  }

  public Short getCustomerId()
  {
    return customerId;
  }

  public void setCustomerId(Short customerId)
  {
    this.customerId = customerId;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public boolean getActive()
  {
    return active;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public Date getCreateDate()
  {
    return createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public Date getLastUpdate()
  {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate)
  {
    this.lastUpdate = lastUpdate;
  }

  public Collection<Rental> getRentalCollection()
  {
    return rentalCollection;
  }

  public void setRentalCollection(Collection<Rental> rentalCollection)
  {
    this.rentalCollection = rentalCollection;
  }

  public Collection<Payment> getPaymentCollection()
  {
    return paymentCollection;
  }

  public void setPaymentCollection(Collection<Payment> paymentCollection)
  {
    this.paymentCollection = paymentCollection;
  }

  public Address getAddressId()
  {
    return addressId;
  }

  public void setAddressId(Address addressId)
  {
    this.addressId = addressId;
  }

  public Store getStoreId()
  {
    return storeId;
  }

  public void setStoreId(Store storeId)
  {
    this.storeId = storeId;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (customerId != null ? customerId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Customer))
    {
      return false;
    }
    Customer other = (Customer) object;
    if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.Customer[ customerId=" + customerId + " ]";
  }

}
