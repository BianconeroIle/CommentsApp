package com.example.ilijaangeleski.cringle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilijaangeleski.cringle.R;
import com.example.ilijaangeleski.cringle.model.Comment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    private List<Comment> comments;
    private Context context;

    public CommentsAdapter(List<Comment> items, Context context) {
        this.comments = items;
        this.context = context;
    }

    @Override
    public CommentsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comments_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.MyViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.id.setText("id : " + comment.getId());
        holder.postId.setText("postId : " + comment.getPostId());
        holder.name.setText("name : " + comment.getName());
        holder.email.setText("email : " + comment.getEmail());
        holder.body.setText("body : " + comment.getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.postId)
        TextView postId;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.email)
        TextView email;
        @BindView(R.id.body)
        TextView body;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
