package com.example.ilijaangeleski.cringle.api;

import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public interface NetworkApi {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("comments")
    Call<List<Comment>> fetchComments();
}
