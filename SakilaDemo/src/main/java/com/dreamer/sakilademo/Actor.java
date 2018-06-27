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
@Table(name = "actor")
@NamedQueries(
{
  @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
  @NamedQuery(name = "Actor.findByActorId", query = "SELECT a FROM Actor a WHERE a.actorId = :actorId"),
  @NamedQuery(name = "Actor.findByFirstName", query = "SELECT a FROM Actor a WHERE a.firstName = :firstName"),
  @NamedQuery(name = "Actor.findByLastName", query = "SELECT a FROM Actor a WHERE a.lastName = :lastName"),
  @NamedQuery(name = "Actor.findByLastUpdate", query = "SELECT a FROM Actor a WHERE a.lastUpdate = :lastUpdate")
})
public class Actor implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "actor_id")
  private Short actorId;
  @Basic(optional = false)
  @Column(name = "first_name")
  private String firstName;
  @Basic(optional = false)
  @Column(name = "last_name")
  private String lastName;
  @Basic(optional = false)
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor")
  private Collection<FilmActor> filmActorCollection;

  public Actor()
  {
  }

  public Actor(Short actorId)
  {
    this.actorId = actorId;
  }

  public Actor(Short actorId, String firstName, String lastName, Date lastUpdate)
  {
    this.actorId = actorId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.lastUpdate = lastUpdate;
  }

  public Short getActorId()
  {
    return actorId;
  }

  public void setActorId(Short actorId)
  {
    this.actorId = actorId;
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

  public Date getLastUpdate()
  {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate)
  {
    this.lastUpdate = lastUpdate;
  }

  public Collection<FilmActor> getFilmActorCollection()
  {
    return filmActorCollection;
  }

  public void setFilmActorCollection(Collection<FilmActor> filmActorCollection)
  {
    this.filmActorCollection = filmActorCollection;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (actorId != null ? actorId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Actor))
    {
      return false;
    }
    Actor other = (Actor) object;
    if ((this.actorId == null && other.actorId != null) || (this.actorId != null && !this.actorId.equals(other.actorId)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.Actor[ actorId=" + actorId + " ]";
  }

}
