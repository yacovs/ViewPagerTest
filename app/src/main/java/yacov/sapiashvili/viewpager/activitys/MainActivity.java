package yacov.sapiashvili.viewpager.activitys;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.ArrayList;

import  yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.adapters.FragmentsViewPagerAdapter;
import  yacov.sapiashvili.viewpager.asynctasks.GetDataAsyncTask;
import  yacov.sapiashvili.viewpager.asynctasks.callbacks.LoadingDataCallback;
import  yacov.sapiashvili.viewpager.model.DLCat;
import  yacov.sapiashvili.viewpager.model.DLObject;

import static android.view.View.LAYOUT_DIRECTION_RTL;

public class MainActivity extends AppCompatActivity implements LoadingDataCallback{
    private final static int NUMBER_OF_TABS = 4;
    private final static String [] TAB_TITLES = {"כל הקטגוריות","המומלצים","הפינוקים שלי","המועדפים"};
    private int mViewPagerPosition = 0;
    private ProgressBar mProgressBar;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PagerPosition", mViewPager.getCurrentItem());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mViewPagerPosition = savedInstanceState.getInt("PagerPosition");
        mViewPager.setCurrentItem(mViewPagerPosition);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
        GetDataAsyncTask loadingTask = new GetDataAsyncTask(this,this);
        loadingTask.execute();
    }

    private void InitViews() {
        mProgressBar = findViewById(R.id.ProgressBar);
        mTabLayout = (TabLayout) findViewById(R.id.TabLayout);
        mViewPager = (ViewPager) findViewById(R.id.pager);
    }

    @Override
    public void loadFinish(ArrayList<DLCat> mDLCat) {
        mProgressBar.setVisibility(View.GONE);
        mViewPager.setAdapter(new FragmentsViewPagerAdapter(getSupportFragmentManager(),mDLCat,TAB_TITLES));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void loadFailed(String msg) {
        //TODO display error msg Dialog
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
