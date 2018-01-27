package com.alienstar.cyrus.recipe.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cyrus on 1/25/18.
 */

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    public final TextView textView;

    public RecipeViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView;
    }
}
