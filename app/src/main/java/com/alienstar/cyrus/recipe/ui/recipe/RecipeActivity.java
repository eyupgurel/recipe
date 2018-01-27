package com.alienstar.cyrus.recipe.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alienstar.cyrus.recipe.R;
import com.alienstar.cyrus.recipe.data.local.IFavorites;
import com.alienstar.cyrus.recipe.data.local.RecipeStore;
import com.alienstar.cyrus.recipe.data.model.Recipe;
import com.alienstar.cyrus.recipe.injection.RecipeApplication;

/**
 * Created by cyrus on 1/25/18.
 */

public class RecipeActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        final TextView titleView = findViewById(R.id.title);
        TextView descView = findViewById(R.id.description);
        String id = getIntent().getStringExtra(KEY_ID);
        RecipeStore store = new RecipeStore(this, "recipes");
        final Recipe recipe =  store.getRecipe(id);
        if(recipe == null){
            titleView.setVisibility(View.GONE);
            descView.setText(R.string.recipe_not_found);
        } else {
            RecipeApplication app = (RecipeApplication) getApplication();
            final IFavorites favorites = app.getFavorites();
            boolean favorite = favorites.get(id);
            titleView.setSelected(favorite);
            titleView.setText(recipe.title);
            titleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean favorite = favorites.toggle(recipe.id);
                    titleView.setSelected(favorite);
                }
            });

            descView.setText(recipe.description);
        }

    }
}
