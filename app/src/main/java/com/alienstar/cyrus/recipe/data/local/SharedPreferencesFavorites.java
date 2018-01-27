package com.alienstar.cyrus.recipe.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cyrus on 1/25/18.
 */

public class SharedPreferencesFavorites implements  IFavorites {
    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE);
    }
    @Override
    public boolean get(String id){
        return pref.getBoolean(id,false);
    }
    @Override
    public boolean toggle(String id){
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }
    public void put (String id, boolean favorite){
        SharedPreferences.Editor editor = pref.edit();
        if(favorite){
            editor.putBoolean(id, favorite);
        } else{
            editor.remove(id);
        }
        editor.apply();
    }
}
