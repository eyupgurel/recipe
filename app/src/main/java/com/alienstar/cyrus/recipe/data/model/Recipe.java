package com.alienstar.cyrus.recipe.data.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by cyrus on 1/25/18.
 */

public class Recipe {
    private static final String TITLE_PREFIX = "title=";
    private static final String ID_PREFIX = "id=";
    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public static Recipe readFromStream(InputStream stream) {
        String id = null;
        String title = null;
        StringBuilder descBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                if(line.startsWith(ID_PREFIX)){
                    id = line.substring(ID_PREFIX.length());
                } else if(line.startsWith(TITLE_PREFIX)){
                    title = line.substring(TITLE_PREFIX.length());
                } else {
                    if(descBuilder.length()>0) descBuilder.append('\n');
                    descBuilder.append(line);
                }
            }
        } catch(IOException ioex){
            return null;
        }
        return new Recipe(id, title, descBuilder.toString());
    }
}
