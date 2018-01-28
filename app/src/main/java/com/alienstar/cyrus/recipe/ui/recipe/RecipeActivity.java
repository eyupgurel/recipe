package com.alienstar.cyrus.recipe.ui.recipe;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.alienstar.cyrus.recipe.R;
import com.alienstar.cyrus.recipe.data.local.IFavorites;
import com.alienstar.cyrus.recipe.data.local.RecipeStore;
import com.alienstar.cyrus.recipe.injection.RecipeApplication;
/**
 * Created by cyrus on 1/25/18.
 */
public class RecipeActivity extends AppCompatActivity implements RecipeContract.View{
    public static final String KEY_ID = "id";
    private TextView titleView;
    private TextView descView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Step 1: Set up the UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        titleView = findViewById(R.id.title);
        descView = findViewById(R.id.description);
        // Step 2: Load recipe from store
        String id = getIntent().getStringExtra(KEY_ID);
        RecipeStore store = new RecipeStore(this, "recipes");
        RecipeApplication app = (RecipeApplication) getApplication();
        final IFavorites favorites = app.getFavorites();
        final RecipePresenter presenter = new RecipePresenter(store, favorites, this);
        presenter.loadRecipe(id);
        // Step 3: If recipe is null, show error. This is done in the presenter.
        // Step 4: If recipe is not null, show recipe. This is done in the presenter.
        // Step 5: When title is clicked, toggle favorites
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.toggleFavorite();

            }
        });
    }
    @Override
    public void showRecipeNotFoundError() {
        titleView.setVisibility(View.GONE);
        descView.setText(R.string.recipe_not_found);
    }
    @Override
    public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override
    public void setDescription(String description) {
        descView.setText(description);
    }

    @Override
    public void setFavorite(boolean favorite) {
        titleView.setSelected(favorite);
    }
}