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

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dreamer.sakilademo.Actor;
import com.dreamer.sakilademo.controller.ActorJpaController;
import com.dreamer.sakilademo.controller.exceptions.IllegalOrphanException;
import com.dreamer.sakilademo.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author Javier Ortiz Bultron <javierortiz@pingidentity.com>
 */
public class Main
{

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    try
    {
      //This opens the database and create tables if needed.
      DatabaseManager.getEntityManager();
      //Create an actor
      Actor a = new Actor(new Short("1"), "Steven", "Segal", new Date());

      ActorJpaController controller
              = new ActorJpaController(DatabaseManager.getEntityManagerFactory());

      //Check how many actors are defined.
      System.out.println(controller.getActorCount() + " actors found!");

      //Store it in the database using the controller
      controller.create(a);

      //Check how many actors are defined.
      System.out.println(controller.getActorCount() + " actors found!");

      //Delete the actor
      controller.destroy(a.getActorId());

      //Check how many actors are defined.
      System.out.println(controller.getActorCount() + " actors found!");
    }
    catch (IllegalOrphanException | NonexistentEntityException ex)
    {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
