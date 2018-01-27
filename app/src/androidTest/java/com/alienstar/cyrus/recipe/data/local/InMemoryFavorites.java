package com.alienstar.cyrus.recipe.data.local;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cyrus on 1/26/18.
 */

public class InMemoryFavorites implements IFavorites {
    private final Map<String, Boolean> map = new HashMap<>();
    @Override
    public boolean get(String id) {
        Boolean value = map.get(id);
        return value == null ? false : true;
    }

    @Override
    public boolean toggle(String id){
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }

    public void put (String id, boolean favorite){
        if(favorite){
            map.put(id, favorite);
        } else{
            map.remove(id);
        }
    }

    public void clear() {
        map.clear();
    }
}