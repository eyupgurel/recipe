package com.alienstar.cyrus.recipe.test;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.alienstar.cyrus.recipe.R;
import com.alienstar.cyrus.recipe.data.local.InMemoryFavorites;
import com.alienstar.cyrus.recipe.injection.TestRecipeApplication;
import com.alienstar.cyrus.recipe.ui.recipe.RecipeActivity;

import org.junit.Before;

/**
 * Created by cyrus on 1/26/18.
 */

public class RecipeRobot extends ScreenRobot<RecipeRobot> {
    private final InMemoryFavorites favorites;
    public RecipeRobot() {
        TestRecipeApplication app = (TestRecipeApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    public RecipeRobot launch(ActivityTestRule rule){
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot launch(ActivityTestRule rule, String id){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    public RecipeRobot noTitle(){
        return checkIsHidden(R.id.title);
    }
    public RecipeRobot hasTitle(String title){
        return checkViewHasText(R.id.title, title);
    }


    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description,stringId);
    }

    public RecipeRobot setFavorite(String id){
        favorites.put(id, true);
        return this;
    }

    public RecipeRobot isFavorite(){
        return checkIsSelected(R.id.title);
    }

    public RecipeRobot isNotFavorite(){
        return checkIsNotSelected(R.id.title);
    }

    public RecipeRobot toggleFavorite(){
        return touch(R.id.title);
    }
}
