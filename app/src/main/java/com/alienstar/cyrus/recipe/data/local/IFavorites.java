package com.alienstar.cyrus.recipe.data.local;

/**
 * Created by cyrus on 1/26/18.
 */

public interface IFavorites {
    boolean get(String id);
    boolean toggle(String id);
}
