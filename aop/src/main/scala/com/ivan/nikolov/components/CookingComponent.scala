package com.ivan.nikolov.components

import com.ivan.nikolov.components.base.Cooker
import com.ivan.nikolov.components.model.Food

trait CookingComponent {
  this: RecipeComponent =>
  
  val cooker: Cooker
  
  class CookerImpl extends Cooker {
    override def cook(what: String): Food = {
      val recipeText = recipe.findRecipe(what)
      Food(s"We just cooked $what using the following recipe: '$recipeText'.")
    }
  }
}
