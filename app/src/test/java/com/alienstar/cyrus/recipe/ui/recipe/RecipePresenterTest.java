package com.alienstar.cyrus.recipe.ui.recipe;
import com.alienstar.cyrus.recipe.data.local.IFavorites;
import com.alienstar.cyrus.recipe.data.local.RecipeStore;
import com.alienstar.cyrus.recipe.data.model.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.io.InputStream;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
/**
 * Created by cyrus on 1/27/18.
 */
public class RecipePresenterTest {
    private RecipeStore store;
    private IFavorites favorites;
    private RecipeContract.View view;
    private RecipePresenter presenter;
    @Before
    public void setup(){
        store = Mockito.mock(RecipeStore.class);
        favorites = Mockito.mock(IFavorites.class);
        view = Mockito.mock(RecipeContract.View.class);
        presenter = new RecipePresenter(store, favorites, view);
    }
    @Test
    public void recipeNotFound(){
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(null);
        presenter.loadRecipe("no-such-recipe");
        Mockito.verify(view, Mockito.times(1)).showRecipeNotFoundError();
    }
    @Test(expected = IllegalStateException.class)
    public void toggleWithoutLoad(){
        presenter.toggleFavorite();
    }
    @Test
    public void loadWaterAndFavorite(){
        InputStream stream = RecipePresenterTest.class.getResourceAsStream("/recipes/mixed.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(recipe);
        Mockito.when(favorites.toggle(Mockito.anyString())).thenReturn(true);
        presenter.loadRecipe("water");
        presenter.toggleFavorite();
        ArgumentCaptor<Boolean> captor = ArgumentCaptor.forClass(Boolean.class);
        Mockito.verify(view, Mockito.times(2)).setFavorite(captor.capture());
        assertFalse(captor.getAllValues().get(0));
        assertTrue(captor.getAllValues().get(1));
    }
}