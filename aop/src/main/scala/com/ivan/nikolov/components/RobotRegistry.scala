package com.ivan.nikolov.components

import com.ivan.nikolov.components.base.{Time, RecipeFinder, Cooker}

class RobotRegistry extends TimeComponent with RecipeComponent with CookingComponent {
  override val time: Time = new TimeImpl
  override val recipe: RecipeFinder = new RecipeFinderImpl
  override val cooker: Cooker = new CookerImpl
}
