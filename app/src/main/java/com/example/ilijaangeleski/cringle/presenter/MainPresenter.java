package com.example.ilijaangeleski.cringle.presenter;

import com.example.ilijaangeleski.cringle.api.NetworkApi;
import com.example.ilijaangeleski.cringle.calback.CommentsCallback;
import com.example.ilijaangeleski.cringle.manager.MainManager;
import com.example.ilijaangeleski.cringle.manager.SharedPreferencesStoreManager;
import com.example.ilijaangeleski.cringle.manager.StorageManager;
import com.example.ilijaangeleski.cringle.model.Comment;
import com.example.ilijaangeleski.cringle.view.MainView;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public class MainPresenter {
    private MainManager mainManager;
    private WeakReference<MainView> weakMainView;

    public MainPresenter(MainView view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetworkApi networkApi = retrofit.create(NetworkApi.class);
        StorageManager storageManager = new SharedPreferencesStoreManager(view.getContext());
        this.mainManager = new MainManager(networkApi, storageManager);
        this.weakMainView = new WeakReference<>(view);
    }

    public void onViewCreated() {
        mainManager.fetchComments(new CommentsCallback() {
            @Override
            public void onSuccess(List<Comment> comments) {
                MainView view = weakMainView.get();
                if (view != null) {
                    view.showComments(comments);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                MainView view = weakMainView.get();
                if (view != null) {
                    view.errorGettingComments();
                }
            }
        });
    }
}
