package com.example.ilijaangeleski.cringle.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ilijaangeleski.cringle.R;
import com.example.ilijaangeleski.cringle.adapter.CommentsTabPagerAdapter;
import com.example.ilijaangeleski.cringle.di.DaggerMainComponent;
import com.example.ilijaangeleski.cringle.di.MainModule;
import com.example.ilijaangeleski.cringle.model.Comment;
import com.example.ilijaangeleski.cringle.presenter.MainPresenter;
import com.example.ilijaangeleski.cringle.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @Inject
    MainPresenter presenter;
    private CommentsTabPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);

        adapter = new CommentsTabPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewCreated();
    }

    @Override
    public void showComments(List<Comment> comments) {
        adapter.setComments(comments);
    }

    @Override
    public void errorGettingComments() {
        Toast.makeText(this, "Failure getting comments from server", Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
