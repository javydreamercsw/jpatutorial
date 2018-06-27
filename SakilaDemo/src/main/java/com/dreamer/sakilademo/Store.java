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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
@Entity
@Table(name = "store")
@NamedQueries(
{
  @NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s"),
  @NamedQuery(name = "Store.findByStoreId", query = "SELECT s FROM Store s WHERE s.storeId = :storeId"),
  @NamedQuery(name = "Store.findByLastUpdate", query = "SELECT s FROM Store s WHERE s.lastUpdate = :lastUpdate")
})
public class Store implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "store_id")
  private Short storeId;
  @Basic(optional = false)
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
  private Collection<Staff> staffCollection;
  @JoinColumn(name = "address_id", referencedColumnName = "address_id")
  @ManyToOne(optional = false)
  private Address addressId;
  @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
  @OneToOne(optional = false)
  private Staff managerStaffId;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
  private Collection<Inventory> inventoryCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
  private Collection<Customer> customerCollection;

  public Store()
  {
  }

  public Store(Short storeId)
  {
    this.storeId = storeId;
  }

  public Store(Short storeId, Date lastUpdate)
  {
    this.storeId = storeId;
    this.lastUpdate = lastUpdate;
  }

  public Short getStoreId()
  {
    return storeId;
  }

  public void setStoreId(Short storeId)
  {
    this.storeId = storeId;
  }

  public Date getLastUpdate()
  {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate)
  {
    this.lastUpdate = lastUpdate;
  }

  public Collection<Staff> getStaffCollection()
  {
    return staffCollection;
  }

  public void setStaffCollection(Collection<Staff> staffCollection)
  {
    this.staffCollection = staffCollection;
  }

  public Address getAddressId()
  {
    return addressId;
  }

  public void setAddressId(Address addressId)
  {
    this.addressId = addressId;
  }

  public Staff getManagerStaffId()
  {
    return managerStaffId;
  }

  public void setManagerStaffId(Staff managerStaffId)
  {
    this.managerStaffId = managerStaffId;
  }

  public Collection<Inventory> getInventoryCollection()
  {
    return inventoryCollection;
  }

  public void setInventoryCollection(Collection<Inventory> inventoryCollection)
  {
    this.inventoryCollection = inventoryCollection;
  }

  public Collection<Customer> getCustomerCollection()
  {
    return customerCollection;
  }

  public void setCustomerCollection(Collection<Customer> customerCollection)
  {
    this.customerCollection = customerCollection;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (storeId != null ? storeId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Store))
    {
      return false;
    }
    Store other = (Store) object;
    if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.Store[ storeId=" + storeId + " ]";
  }

}
