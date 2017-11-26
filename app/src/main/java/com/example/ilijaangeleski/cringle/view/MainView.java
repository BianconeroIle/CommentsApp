package com.example.ilijaangeleski.cringle.view;

import android.content.Context;

import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.List;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public interface MainView {
    void showComments(List<Comment> comments);
    void errorGettingComments();
    Context getContext();
}
