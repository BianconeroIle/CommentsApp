package com.example.ilijaangeleski.cringle.manager;

import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.List;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public interface StorageManager {
    void saveComments(List<Comment> comments);
    List<Comment> getComments();
}
