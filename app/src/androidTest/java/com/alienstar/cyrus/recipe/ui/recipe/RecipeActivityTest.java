package com.alienstar.cyrus.recipe.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.alienstar.cyrus.recipe.R;
import com.alienstar.cyrus.recipe.data.local.InMemoryFavorites;
import com.alienstar.cyrus.recipe.injection.TestRecipeApplication;
import com.alienstar.cyrus.recipe.test.RecipeRobot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by cyrus on 1/26/18.
 */
public class RecipeActivityTest {
    private static final String CARROTS_ID = "creamed_carrots";
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule = new ActivityTestRule<>(RecipeActivity.class,
                                                                                  true,
                                                                                  false);
    @Test
    public void recipeNotFound(){
        new RecipeRobot().launch(activityRule)
                .noTitle().description(R.string.recipe_not_found);
    }
    @Test
    public void clickToFavorite(){
        new RecipeRobot().launch(activityRule, CARROTS_ID)
                         .hasTitle("Creamed Carrots")
                         .isNotFavorite()
                         .toggleFavorite()
                         .isFavorite();
    }
    @Test
    public void alreadyFavorite(){
            new RecipeRobot().setFavorite(CARROTS_ID).
                    launch(activityRule, CARROTS_ID).
                    isFavorite();
    }
}