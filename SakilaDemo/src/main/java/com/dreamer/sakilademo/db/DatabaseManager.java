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
package com.dreamer.sakilademo.db;

import static java.util.logging.Logger.getLogger;
import static javax.persistence.Persistence.createEntityManagerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Javier A. Ortiz Bultron javier.ortiz.78@gmail.com
 */
public class DatabaseManager
{

  private static EntityManagerFactory emf;
  private static Map<String, Object> properties;
  //Default. Can be overwritten using setPersistenceUnitName(String aPU)
  private static String PU = "PU";
  private static EntityManager em;
  private static final Logger LOG
          = getLogger(DatabaseManager.class.getSimpleName());
  private static boolean locked = false;

  private DatabaseManager()
  {
  }

  /**
   * @return the properties
   */
  public static Map<String, Object> getProperties()
  {
    return properties;
  }

  /**
   * Get the current persistence unit name
   *
   * @return current persistence unit name
   */
  public static String getPersistenceUnitName()
  {
    return PU;
  }

  /**
   * @param aPU the PU to set
   */
  public static void setPersistenceUnitName(String aPU)
  {
    PU = aPU;
    LOG.log(Level.FINE, "Changed persistence unit name to: {0}", PU);
    //Set it to null so it's recreated with new Persistence Unit next time is requested.
    emf = null;
    em = null;
  }

  public static void setEntityManagerFactory(EntityManagerFactory newEMF)
  {
    emf = newEMF;
  }

  /**
   * @return the emf
   */
  public static EntityManagerFactory getEntityManagerFactory()
  {
    if (emf == null)
    {
      emf = createEntityManagerFactory(PU);
    }
    return emf;
  }

  public static EntityManager getEntityManager()
  {
    if (em == null)
    {
      em = getEntityManagerFactory().createEntityManager();
      LOG.log(Level.FINE,
              "Creating EntityManager from: {0}", PU);
      properties = em.getProperties();
    }
    return em;
  }

  public static List<Object> createdQuery(String query)
  {
    return createdQuery(query, null);
  }

  @SuppressWarnings("unchecked")
  public static List<Object> createdQuery(String query, Map<String, Object> parameters)
  {
    Query q = getEntityManager().createQuery(query);
    if (parameters != null)
    {
      Iterator<Entry<String, Object>> entries = parameters.entrySet().iterator();
      while (entries.hasNext())
      {
        Entry<String, Object> e = entries.next();
        q.setParameter(e.getKey(), e.getValue());
      }
    }
    return q.getResultList();
  }

  /**
   * Named query that will modify the database
   *
   * @param query query to execute
   */
  public static void namedUpdateQuery(String query)
  {
    namedQuery(query, null, true);
  }

  public static List<Object> nativeQuery(String query)
  {
    List<Object> resultList
            = getEntityManager().createNativeQuery(query).getResultList();
    return resultList;
  }

  public static <T extends Object> List<T> createdQuery(String query, T result)
  {
    List<T> resultList
            = getEntityManager().createQuery(query).getResultList();
    return resultList;
  }

  public static void nativeUpdateQuery(String query)
  {
    getEntityManager().createNativeQuery(query).executeUpdate();
  }

  /**
   * Named query (not for updates)
   *
   * @param query query to execute
   * @return query result
   */
  public static List<Object> namedQuery(String query)
  {
    return namedQuery(query, null, false);
  }

  /**
   * Named query that will modify the database
   *
   * @param query query to execute
   * @param parameters query parameters
   */
  public static void namedUpdateQuery(String query, Map<String, Object> parameters)
  {
    namedQuery(query, parameters, true);
  }

  /**
   * Named query (not for updates)
   *
   * @param query query to execute
   * @param parameters query parameters
   * @return query result
   */
  public static List<Object> namedQuery(String query,
          Map<String, Object> parameters)
  {
    return namedQuery(query, parameters, false);
  }

  @SuppressWarnings("unchecked")
  private static List<Object> namedQuery(String query,
          Map<String, Object> parameters, boolean change)
  {
    EntityTransaction transaction = getEntityManager().getTransaction();
    if (change)
    {
      transaction.begin();
    }
    Query q = getEntityManager().createNamedQuery(query);
    if (parameters != null)
    {
      Iterator<Entry<String, Object>> entries
              = parameters.entrySet().iterator();
      while (entries.hasNext())
      {
        Entry<String, Object> e = entries.next();
        q.setParameter(e.getKey(), e.getValue());
      }
    }
    if (change)
    {
      transaction.commit();
    }
    return q.getResultList();
  }

  public static void close()
  {
    getEntityManager().close();
    getEntityManagerFactory().close();
    emf = null;
    em = null;
  }

  /**
   * @param lock the lock to set
   */
  public static void setLocked(boolean lock)
  {
    LOG.log(Level.WARNING, "{0} the database.",
            (lock ? "Locking" : "Unlocking"));
    locked = lock;
  }

  /**
   * @return the locked
   */
  public static boolean isLocked()
  {
    return locked;
  }
}
