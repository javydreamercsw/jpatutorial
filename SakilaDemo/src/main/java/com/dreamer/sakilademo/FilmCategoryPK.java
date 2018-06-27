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
import javax.persistence.Embeddable;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
@Embeddable
public class FilmCategoryPK implements Serializable
{
  @Basic(optional = false)
  @Column(name = "film_id")
  private short filmId;
  @Basic(optional = false)
  @Column(name = "category_id")
  private short categoryId;

  public FilmCategoryPK()
  {
  }

  public FilmCategoryPK(short filmId, short categoryId)
  {
    this.filmId = filmId;
    this.categoryId = categoryId;
  }

  public short getFilmId()
  {
    return filmId;
  }

  public void setFilmId(short filmId)
  {
    this.filmId = filmId;
  }

  public short getCategoryId()
  {
    return categoryId;
  }

  public void setCategoryId(short categoryId)
  {
    this.categoryId = categoryId;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (int) filmId;
    hash += (int) categoryId;
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FilmCategoryPK))
    {
      return false;
    }
    FilmCategoryPK other = (FilmCategoryPK) object;
    if (this.filmId != other.filmId)
    {
      return false;
    }
    if (this.categoryId != other.categoryId)
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.FilmCategoryPK[ filmId=" + filmId + ", categoryId=" + categoryId + " ]";
  }

}
