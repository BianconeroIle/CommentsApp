package com.example.ilijaangeleski.cringle.manager;

import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */
public class CommentsManager {

    public void sortById(List<Comment> commentList) {
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return Integer.valueOf(c2.getId()).compareTo(c1.getId());
            }
        });
    }

    public void sortByEmail(List<Comment> commentList) {
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return c1.getEmail().compareTo(c2.getEmail());
            }
        });
    }

    public void showEvenPosts(List<Comment> commentList) {
        Iterator<Comment> iterator = commentList.iterator();
        while (iterator.hasNext()) {
            Comment comment = iterator.next();
            if (comment.getPostId() % 2 != 0) {
                iterator.remove();
            }
        }
    }
}
