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
@Table(name = "inventory")
@NamedQueries(
{
  @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
  @NamedQuery(name = "Inventory.findByInventoryId", query = "SELECT i FROM Inventory i WHERE i.inventoryId = :inventoryId"),
  @NamedQuery(name = "Inventory.findByLastUpdate", query = "SELECT i FROM Inventory i WHERE i.lastUpdate = :lastUpdate")
})
public class Inventory implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "inventory_id")
  private Integer inventoryId;
  @Basic(optional = false)
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @JoinColumn(name = "film_id", referencedColumnName = "film_id")
  @ManyToOne(optional = false)
  private Film filmId;
  @JoinColumn(name = "store_id", referencedColumnName = "store_id")
  @ManyToOne(optional = false)
  private Store storeId;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryId")
  private Collection<Rental> rentalCollection;

  public Inventory()
  {
  }

  public Inventory(Integer inventoryId)
  {
    this.inventoryId = inventoryId;
  }

  public Inventory(Integer inventoryId, Date lastUpdate)
  {
    this.inventoryId = inventoryId;
    this.lastUpdate = lastUpdate;
  }

  public Integer getInventoryId()
  {
    return inventoryId;
  }

  public void setInventoryId(Integer inventoryId)
  {
    this.inventoryId = inventoryId;
  }

  public Date getLastUpdate()
  {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate)
  {
    this.lastUpdate = lastUpdate;
  }

  public Film getFilmId()
  {
    return filmId;
  }

  public void setFilmId(Film filmId)
  {
    this.filmId = filmId;
  }

  public Store getStoreId()
  {
    return storeId;
  }

  public void setStoreId(Store storeId)
  {
    this.storeId = storeId;
  }

  public Collection<Rental> getRentalCollection()
  {
    return rentalCollection;
  }

  public void setRentalCollection(Collection<Rental> rentalCollection)
  {
    this.rentalCollection = rentalCollection;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (inventoryId != null ? inventoryId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Inventory))
    {
      return false;
    }
    Inventory other = (Inventory) object;
    if ((this.inventoryId == null && other.inventoryId != null) || (this.inventoryId != null && !this.inventoryId.equals(other.inventoryId)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.Inventory[ inventoryId=" + inventoryId + " ]";
  }

}
