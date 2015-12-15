/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter29_ModularProgrammingUsingObjects.C_Linking

import ProgrammingInScala_OderskyBook.Chapter29_ModularProgrammingUsingObjects.B_SplittingModulesIntoTraits.{Browser, SimpleDatabase, StudentDatabase, Database}

/**
 * Created by archeg on 10/9/2015.
 */
object Main extends App {
  // Dynamic linking
  val db: Database =
    if(args(0) == "student")
      StudentDatabase
    else
      SimpleDatabase

  object browser extends Browser {
    val database: db.type = db
  }

//  for (category <- db.allCategories)
//    browser.displayCategory(category)

  val apple = SimpleDatabase.foodNamed("Apple").get

  for(recipe <- browser.recipesUsing(apple))
    println(recipe)
}
