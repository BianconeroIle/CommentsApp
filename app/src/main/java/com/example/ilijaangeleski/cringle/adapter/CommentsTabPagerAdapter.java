package com.example.ilijaangeleski.cringle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ilijaangeleski.cringle.model.Comment;
import com.example.ilijaangeleski.cringle.ui.CommentsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilija Angeleski on 11/26/2017.
 */

public class CommentsTabPagerAdapter extends FragmentPagerAdapter {
    private List<CommentsFragment> fragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public CommentsTabPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(CommentsFragment.createInstance(CommentsFragment.TYPE_ONE));
        fragmentList.add(CommentsFragment.createInstance(CommentsFragment.TYPE_TWO));
        fragmentList.add(CommentsFragment.createInstance(CommentsFragment.TYPE_THREE));

        titles.add("By ID");
        titles.add("By EMAIL");
        titles.add("By postID");
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void setComments(List<Comment> commentList) {
        for (CommentsFragment fragment : fragmentList) {
            fragment.setComments(commentList);
        }
    }
}
