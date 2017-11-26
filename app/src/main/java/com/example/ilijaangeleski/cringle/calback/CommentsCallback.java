package com.example.ilijaangeleski.cringle.calback;

import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.List;

public interface CommentsCallback {
    void onSuccess(List<Comment> comments);
    void onFailure(Throwable t);
}