package com.example.ilijaangeleski.cringle.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ilijaangeleski.cringle.model.Comment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public class SharedPreferencesStoreManager implements StorageManager{

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesStoreManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public List<Comment> getComments() {
        Gson gson = new Gson();
        String getComments = sharedPreferences.getString("comments", "");
        return gson.fromJson(getComments, new TypeToken<List<Comment>>() {}.getType());
    }

    public void saveComments(List<Comment> comments) {
        Gson gson = new Gson();
        String toJson = gson.toJson(comments);
        editor.putString("comments", toJson);
        editor.apply();
    }
}
