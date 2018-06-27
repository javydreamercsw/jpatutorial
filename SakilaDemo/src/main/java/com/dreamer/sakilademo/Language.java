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
@Table(name = "language")
@NamedQueries(
{
  @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
  @NamedQuery(name = "Language.findByLanguageId", query = "SELECT l FROM Language l WHERE l.languageId = :languageId"),
  @NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name = :name"),
  @NamedQuery(name = "Language.findByLastUpdate", query = "SELECT l FROM Language l WHERE l.lastUpdate = :lastUpdate")
})
public class Language implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "language_id")
  private Short languageId;
  @Basic(optional = false)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId")
  private Collection<Film> filmCollection;
  @OneToMany(mappedBy = "originalLanguageId")
  private Collection<Film> filmCollection1;

  public Language()
  {
  }

  public Language(Short languageId)
  {
    this.languageId = languageId;
  }

  public Language(Short languageId, String name, Date lastUpdate)
  {
    this.languageId = languageId;
    this.name = name;
    this.lastUpdate = lastUpdate;
  }

  public Short getLanguageId()
  {
    return languageId;
  }

  public void setLanguageId(Short languageId)
  {
    this.languageId = languageId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Date getLastUpdate()
  {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate)
  {
    this.lastUpdate = lastUpdate;
  }

  public Collection<Film> getFilmCollection()
  {
    return filmCollection;
  }

  public void setFilmCollection(Collection<Film> filmCollection)
  {
    this.filmCollection = filmCollection;
  }

  public Collection<Film> getFilmCollection1()
  {
    return filmCollection1;
  }

  public void setFilmCollection1(Collection<Film> filmCollection1)
  {
    this.filmCollection1 = filmCollection1;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (languageId != null ? languageId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Language))
    {
      return false;
    }
    Language other = (Language) object;
    if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.Language[ languageId=" + languageId + " ]";
  }

}
