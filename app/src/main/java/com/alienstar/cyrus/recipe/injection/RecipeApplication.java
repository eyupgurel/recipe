package com.alienstar.cyrus.recipe.injection;

import android.app.Application;

import com.alienstar.cyrus.recipe.data.local.IFavorites;
import com.alienstar.cyrus.recipe.data.local.SharedPreferencesFavorites;

/**
 * Created by cyrus on 1/26/18.
 */

public class RecipeApplication extends Application {
    private IFavorites favorites = null;
    public IFavorites getFavorites() {
        if (favorites == null) {
            favorites = new SharedPreferencesFavorites(this);
        }
        return favorites;

    }
}
