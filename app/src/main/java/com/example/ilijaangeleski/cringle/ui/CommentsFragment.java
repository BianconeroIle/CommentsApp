package com.example.ilijaangeleski.cringle.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilijaangeleski.cringle.R;
import com.example.ilijaangeleski.cringle.adapter.CommentsAdapter;
import com.example.ilijaangeleski.cringle.manager.CommentsManager;
import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public class CommentsFragment extends Fragment {
    public static final String TYPE_ONE = "type_one";
    public static final String TYPE_TWO = "type_two";
    public static final String TYPE_THREE = "type_three";
    public static final String FRAGMENT_TYPE = "fragment_type";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private String fragmentType;
    private CommentsAdapter commentsAdapter;
    private CommentsManager commentsManager;
    private List<Comment> comments = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comments_fragment, container, false);
        ButterKnife.bind(this,view);
        fragmentType = getArguments().getString(FRAGMENT_TYPE, TYPE_ONE);
        commentsManager = new CommentsManager();

        commentsAdapter = new CommentsAdapter(comments, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(commentsAdapter);

        return view;
    }

    public static CommentsFragment createInstance(String type) {
        CommentsFragment fragment = new CommentsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TYPE, type);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        commentsAdapter.notifyDataSetChanged();
        notifyDataHasChanged();
    }

    public void setComments(List<Comment> comments) {
        this.comments.addAll(comments);
        notifyDataHasChanged();
    }

    private void notifyDataHasChanged() {
        if(isAdded()) {
            switch (fragmentType) {
                case TYPE_ONE:
                    commentsManager.sortById(this.comments);
                    break;
                case TYPE_TWO:
                    commentsManager.sortByEmail(this.comments);
                    break;
                case TYPE_THREE:
                    commentsManager.showEvenPosts(this.comments);
                    break;
            }
            commentsAdapter.notifyDataSetChanged();
        }
    }
}
