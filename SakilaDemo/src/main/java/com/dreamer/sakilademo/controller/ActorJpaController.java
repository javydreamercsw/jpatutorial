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
package com.dreamer.sakilademo.controller;

import java.io.Serializable;

import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.dreamer.sakilademo.FilmActor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dreamer.sakilademo.Actor;
import com.dreamer.sakilademo.controller.exceptions.IllegalOrphanException;
import com.dreamer.sakilademo.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
public class ActorJpaController implements Serializable
{
  public ActorJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Actor actor)
  {
    if (actor.getFilmActorCollection() == null)
    {
      actor.setFilmActorCollection(new ArrayList<FilmActor>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Collection<FilmActor> attachedFilmActorCollection = new ArrayList<FilmActor>();
      for (FilmActor filmActorCollectionFilmActorToAttach : actor.getFilmActorCollection())
      {
        filmActorCollectionFilmActorToAttach = em.getReference(filmActorCollectionFilmActorToAttach.getClass(), filmActorCollectionFilmActorToAttach.getFilmActorPK());
        attachedFilmActorCollection.add(filmActorCollectionFilmActorToAttach);
      }
      actor.setFilmActorCollection(attachedFilmActorCollection);
      em.persist(actor);
      for (FilmActor filmActorCollectionFilmActor : actor.getFilmActorCollection())
      {
        Actor oldActorOfFilmActorCollectionFilmActor = filmActorCollectionFilmActor.getActor();
        filmActorCollectionFilmActor.setActor(actor);
        filmActorCollectionFilmActor = em.merge(filmActorCollectionFilmActor);
        if (oldActorOfFilmActorCollectionFilmActor != null)
        {
          oldActorOfFilmActorCollectionFilmActor.getFilmActorCollection().remove(filmActorCollectionFilmActor);
          oldActorOfFilmActorCollectionFilmActor = em.merge(oldActorOfFilmActorCollectionFilmActor);
        }
      }
      em.getTransaction().commit();
    }
    finally
    {
      if (em != null)
      {
        em.close();
      }
    }
  }

  public void edit(Actor actor) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Actor persistentActor = em.find(Actor.class, actor.getActorId());
      Collection<FilmActor> filmActorCollectionOld = persistentActor.getFilmActorCollection();
      Collection<FilmActor> filmActorCollectionNew = actor.getFilmActorCollection();
      List<String> illegalOrphanMessages = null;
      for (FilmActor filmActorCollectionOldFilmActor : filmActorCollectionOld)
      {
        if (!filmActorCollectionNew.contains(filmActorCollectionOldFilmActor))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain FilmActor " + filmActorCollectionOldFilmActor + " since its actor field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      Collection<FilmActor> attachedFilmActorCollectionNew = new ArrayList<FilmActor>();
      for (FilmActor filmActorCollectionNewFilmActorToAttach : filmActorCollectionNew)
      {
        filmActorCollectionNewFilmActorToAttach = em.getReference(filmActorCollectionNewFilmActorToAttach.getClass(), filmActorCollectionNewFilmActorToAttach.getFilmActorPK());
        attachedFilmActorCollectionNew.add(filmActorCollectionNewFilmActorToAttach);
      }
      filmActorCollectionNew = attachedFilmActorCollectionNew;
      actor.setFilmActorCollection(filmActorCollectionNew);
      actor = em.merge(actor);
      for (FilmActor filmActorCollectionNewFilmActor : filmActorCollectionNew)
      {
        if (!filmActorCollectionOld.contains(filmActorCollectionNewFilmActor))
        {
          Actor oldActorOfFilmActorCollectionNewFilmActor = filmActorCollectionNewFilmActor.getActor();
          filmActorCollectionNewFilmActor.setActor(actor);
          filmActorCollectionNewFilmActor = em.merge(filmActorCollectionNewFilmActor);
          if (oldActorOfFilmActorCollectionNewFilmActor != null && !oldActorOfFilmActorCollectionNewFilmActor.equals(actor))
          {
            oldActorOfFilmActorCollectionNewFilmActor.getFilmActorCollection().remove(filmActorCollectionNewFilmActor);
            oldActorOfFilmActorCollectionNewFilmActor = em.merge(oldActorOfFilmActorCollectionNewFilmActor);
          }
        }
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        Short id = actor.getActorId();
        if (findActor(id) == null)
        {
          throw new NonexistentEntityException("The actor with id " + id + " no longer exists.");
        }
      }
      throw ex;
    }
    finally
    {
      if (em != null)
      {
        em.close();
      }
    }
  }

  public void destroy(Short id) throws IllegalOrphanException, NonexistentEntityException
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Actor actor;
      try
      {
        actor = em.getReference(Actor.class, id);
        actor.getActorId();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The actor with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      Collection<FilmActor> filmActorCollectionOrphanCheck = actor.getFilmActorCollection();
      for (FilmActor filmActorCollectionOrphanCheckFilmActor : filmActorCollectionOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Actor (" + actor + ") cannot be destroyed since the FilmActor " + filmActorCollectionOrphanCheckFilmActor + " in its filmActorCollection field has a non-nullable actor field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      em.remove(actor);
      em.getTransaction().commit();
    }
    finally
    {
      if (em != null)
      {
        em.close();
      }
    }
  }

  public List<Actor> findActorEntities()
  {
    return findActorEntities(true, -1, -1);
  }

  public List<Actor> findActorEntities(int maxResults, int firstResult)
  {
    return findActorEntities(false, maxResults, firstResult);
  }

  private List<Actor> findActorEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Actor.class));
      Query q = em.createQuery(cq);
      if (!all)
      {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public Actor findActor(Short id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Actor.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getActorCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Actor> rt = cq.from(Actor.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    }
    finally
    {
      em.close();
    }
  }

}
