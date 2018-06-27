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
public class FilmActorPK implements Serializable
{
  @Basic(optional = false)
  @Column(name = "actor_id")
  private short actorId;
  @Basic(optional = false)
  @Column(name = "film_id")
  private short filmId;

  public FilmActorPK()
  {
  }

  public FilmActorPK(short actorId, short filmId)
  {
    this.actorId = actorId;
    this.filmId = filmId;
  }

  public short getActorId()
  {
    return actorId;
  }

  public void setActorId(short actorId)
  {
    this.actorId = actorId;
  }

  public short getFilmId()
  {
    return filmId;
  }

  public void setFilmId(short filmId)
  {
    this.filmId = filmId;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (int) actorId;
    hash += (int) filmId;
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FilmActorPK))
    {
      return false;
    }
    FilmActorPK other = (FilmActorPK) object;
    if (this.actorId != other.actorId)
    {
      return false;
    }
    if (this.filmId != other.filmId)
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "com.dreamer.sakilademo.FilmActorPK[ actorId=" + actorId + ", filmId=" + filmId + " ]";
  }

}
