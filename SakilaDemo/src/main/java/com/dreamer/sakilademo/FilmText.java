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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
@Entity
@Table(name = "film_text")
@NamedQueries(
{
  @NamedQuery(name = "FilmText.findAll", query = "SELECT f FROM FilmText f"),
  @NamedQuery(name = "FilmText.findByFilmId", query = "SELECT f FROM FilmText f WHERE f.filmId = :filmId"),
  @NamedQuery(name = "FilmText.findByTitle", query = "SELECT f FROM FilmText f WHERE f.title = :title")
})
public class FilmText implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "film_id")
  private Short filmId;
  @Basic(optional = false)
  @Column(name = "title")
  private String title;
  @Lob
  @Column(name = "description")
  private String description;

  public FilmText()
  {
  }

  public FilmText(Short filmId)
  {
    this.filmId = filmId;
  }

  public FilmText(Short filmId, String title)
  {
    this.filmId = filmId;
    this.title = title;
  }

  public Short getFilmId()
  {
    return filmId;
  }

  public void setFilmId(Short filmId)
  {
    this.filmId = filmId;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (filmId != null ? filmId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FilmText))
    {
      return false;
    }
    FilmText other = (FilmText) object;
    if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.FilmText[ filmId=" + filmId + " ]";
  }

}
