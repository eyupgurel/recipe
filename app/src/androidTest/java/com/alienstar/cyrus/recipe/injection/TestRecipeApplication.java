package com.alienstar.cyrus.recipe.injection;
import com.alienstar.cyrus.recipe.data.local.IFavorites;
import com.alienstar.cyrus.recipe.data.local.InMemoryFavorites;
import com.alienstar.cyrus.recipe.data.local.SharedPreferencesFavorites;

/**
 * Created by cyrus on 1/26/18.
 */

public class TestRecipeApplication extends RecipeApplication {
    private final IFavorites favorites = new InMemoryFavorites();
    @Override
     public IFavorites getFavorites() {
       return favorites;
     }
}
