package yacov.sapiashvili.viewpager.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import yacov.sapiashvili.viewpager.fragments.AllCatsFragment;
import  yacov.sapiashvili.viewpager.fragments.BaseFragment;
import yacov.sapiashvili.viewpager.fragments.RecommendedFragment;
import  yacov.sapiashvili.viewpager.model.DLCat;

/**
 * Created by yaacovs on 28/12/2017.
 */

public class FragmentsViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<DLCat> mDLCatsList;
    String [] mTabTitles;
    public FragmentsViewPagerAdapter(FragmentManager fm, ArrayList<DLCat> cats,String [] titles) {
        super(fm);
        mDLCatsList = cats;
        mTabTitles = titles;
    }

    @Override
    public BaseFragment getItem(int position) {
        switch (position){
            case 0:{
                BaseFragment fragment = AllCatsFragment.newInstance(position,mDLCatsList);
                return fragment;
            }
            case 1:{
                BaseFragment fragment = RecommendedFragment.newInstance(position,mDLCatsList);
                return fragment;
            }default:{
                BaseFragment fragment = BaseFragment.newInstance(position);
                return fragment;
            }

        }

    }

    @Override
    public int getCount() {
        return mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return mTabTitles[position];
    }
}
