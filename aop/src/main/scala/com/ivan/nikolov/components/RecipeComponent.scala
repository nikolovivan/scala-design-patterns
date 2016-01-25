package com.ivan.nikolov.components

import com.ivan.nikolov.components.base.RecipeFinder


trait RecipeComponent {
  val recipe: RecipeFinder

  class RecipeFinderImpl extends RecipeFinder {
    override def findRecipe(dish: String): String = dish match {
      case "chips" => "Fry the potatoes for 10 minutes."
      case "fish" => "Clean the fish and put in the oven for 30 minutes."
      case "sandwich" => "Put butter, ham and cheese on the bread, toast and add tomatoes."
      case _ => throw new RuntimeException(s"${dish} is unknown recipe.")
    }
  }
}
