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
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
@Entity
@Table(name = "film_category")
@NamedQueries(
{
  @NamedQuery(name = "FilmCategory.findAll", query = "SELECT f FROM FilmCategory f"),
  @NamedQuery(name = "FilmCategory.findByFilmId", query = "SELECT f FROM FilmCategory f WHERE f.filmCategoryPK.filmId = :filmId"),
  @NamedQuery(name = "FilmCategory.findByCategoryId", query = "SELECT f FROM FilmCategory f WHERE f.filmCategoryPK.categoryId = :categoryId"),
  @NamedQuery(name = "FilmCategory.findByLastUpdate", query = "SELECT f FROM FilmCategory f WHERE f.lastUpdate = :lastUpdate")
})
public class FilmCategory implements Serializable
{
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FilmCategoryPK filmCategoryPK;
  @Basic(optional = false)
  @Column(name = "last_update")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdate;
  @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Category category;
  @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Film film;

  public FilmCategory()
  {
  }

  public FilmCategory(FilmCategoryPK filmCategoryPK)
  {
    this.filmCategoryPK = filmCategoryPK;
  }

  public FilmCategory(FilmCategoryPK filmCategoryPK, Date lastUpdate)
  {
    this.filmCategoryPK = filmCategoryPK;
    this.lastUpdate = lastUpdate;
  }

  public FilmCategory(short filmId, short categoryId)
  {
    this.filmCategoryPK = new FilmCategoryPK(filmId, categoryId);
  }

  public FilmCategoryPK getFilmCategoryPK()
  {
    return filmCategoryPK;
  }

  public void setFilmCategoryPK(FilmCategoryPK filmCategoryPK)
  {
    this.filmCategoryPK = filmCategoryPK;
  }

  public Date getLastUpdate()
  {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate)
  {
    this.lastUpdate = lastUpdate;
  }

  public Category getCategory()
  {
    return category;
  }

  public void setCategory(Category category)
  {
    this.category = category;
  }

  public Film getFilm()
  {
    return film;
  }

  public void setFilm(Film film)
  {
    this.film = film;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (filmCategoryPK != null ? filmCategoryPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FilmCategory))
    {
      return false;
    }
    FilmCategory other = (FilmCategory) object;
    if ((this.filmCategoryPK == null && other.filmCategoryPK != null) || (this.filmCategoryPK != null && !this.filmCategoryPK.equals(other.filmCategoryPK)))
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.FilmCategory[ filmCategoryPK=" + filmCategoryPK + " ]";
  }

}
