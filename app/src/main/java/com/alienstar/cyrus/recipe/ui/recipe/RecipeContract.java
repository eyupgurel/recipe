package com.alienstar.cyrus.recipe.ui.recipe;
/**
 * Created by cyrus on 1/27/18.
 */
public interface RecipeContract {
    interface View {
        void showRecipeNotFoundError();
        void setTitle(String title);
        void setDescription(String description);
        void setFavorite(boolean favorite);
    }
    interface Listener {
    }
}
