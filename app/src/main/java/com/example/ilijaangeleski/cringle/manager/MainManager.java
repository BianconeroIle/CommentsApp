package com.example.ilijaangeleski.cringle.manager;

import com.example.ilijaangeleski.cringle.api.NetworkApi;
import com.example.ilijaangeleski.cringle.calback.CommentsCallback;
import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public class MainManager {
    private NetworkApi networkApi;
    private StorageManager storageManager;

    public MainManager(NetworkApi api, StorageManager storageManager) {
        this.networkApi = api;
        this.storageManager = storageManager;
    }

    public void fetchComments(final CommentsCallback commentsCallback) {
        Call<List<Comment>> call = networkApi.fetchComments();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                commentsCallback.onSuccess(response.body());
                storageManager.saveComments(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                commentsCallback.onFailure(t);
            }
        });
    }
}
