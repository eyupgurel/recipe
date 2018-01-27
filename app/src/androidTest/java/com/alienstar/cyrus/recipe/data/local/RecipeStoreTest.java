package com.alienstar.cyrus.recipe.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.alienstar.cyrus.recipe.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cyrus on 1/25/18.
 */
public class RecipeStoreTest {
    @Test
    public void nullDirectory(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());

    }
    @Test
    public void count(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(4, store.recipes.size());

    }
    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals(recipe.id,"chocolate_pudding");
        assertEquals(recipe.title, "Chocolate Pudding");
        assertEquals(recipe.description, "2 tablespoons chocolate\n" +
                                                "yolks of 4 eggs\n" +
                                                "1 cup sugar\n" +
                                                "1 quart milk\n" +
                                                "1 whole egg\n" +
                                                "2 tablespoons corn starch\n" +
                                                "\n" +
                                                "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred.");
    }

}