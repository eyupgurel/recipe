package com.alienstar.cyrus.recipe.ui.recipe;
import com.alienstar.cyrus.recipe.data.local.IFavorites;
import com.alienstar.cyrus.recipe.data.local.RecipeStore;
import com.alienstar.cyrus.recipe.data.model.Recipe;
/**
 * Created by cyrus on 1/27/18.
 */
public class RecipePresenter implements RecipeContract.Listener {
    private final RecipeStore store;
    private final IFavorites favorites;
    private RecipeContract.View view;
    private Recipe recipe;
    public RecipePresenter(RecipeStore store, IFavorites favorites, RecipeContract.View view) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;
    }
    public void loadRecipe(String id){
        recipe = store.getRecipe(id);
        if(recipe == null){
            view.showRecipeNotFoundError();
        } else  {
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorite(favorites.get(recipe.id));
        }
    }
    public void toggleFavorite() {
        if(recipe == null){
            throw new IllegalStateException();
        }
        boolean favorite = favorites.toggle(recipe.id);
        view.setFavorite(favorite);
    }
}