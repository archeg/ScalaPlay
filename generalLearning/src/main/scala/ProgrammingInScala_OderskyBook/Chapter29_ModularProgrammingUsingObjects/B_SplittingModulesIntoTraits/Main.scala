/*
 * Copyright (c) 2015. Written by Iurii Gazin (archeg@gmail.com)
 */

package ProgrammingInScala_OderskyBook.Chapter29_ModularProgrammingUsingObjects.B_SplittingModulesIntoTraits

import ProgrammingInScala_OderskyBook.Chapter29_ModularProgrammingUsingObjects.A_Recipe._

/**
 * Created by archeg on 10/9/2015.
 */
object Main extends App {
  val apple = SimpleDatabase.foodNamed("Apple").get
  println(SimpleBrowser.recipesUsing(apple))
}

trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}

abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String) = allFoods.find(f => f.name == name)
}

object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes

trait SimpleFoods {
  object Pear extends Food("Pear")
  def allFoods = List(Apple, Pear)
  def allCategories = Nil
}

trait SimpleRecipes {
  this: SimpleFoods =>                      // self type.
  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Pear),
    "Mix it all together."
  )
  def allRecipes = List(FruitSalad)
}

object StudentDatabase extends Database {
  object FrozenFood extends Food("FrozenFood")
  object HeatItUp extends Recipe(
    "heat it up",
    List(FrozenFood),
    "Microwave the 'food' for 10 minutes."
  )

  def allFoods = List(FrozenFood)
  def allRecipes = List(HeatItUp)
  def allCategories = List(
    FoodCategory("edible", List(FrozenFood))
  )
}

object StudentBrowser extends Browser {
  val database = StudentDatabase
}


abstract class Browser {
  val database: Database

  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCategory(category: SimpleDatabase.FoodCategory){
    println(category)
  }
}
