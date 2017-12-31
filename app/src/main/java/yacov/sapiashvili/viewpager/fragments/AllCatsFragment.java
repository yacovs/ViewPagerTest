package yacov.sapiashvili.viewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;

import yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.adapters.DLCatAdapter;
import yacov.sapiashvili.viewpager.model.DLCat;
import yacov.sapiashvili.viewpager.views.LinearLayoutManagerWithSmoothScroller;

/**
 * Created by yaacovs on 30/12/2017.
 */

public class AllCatsFragment extends BaseFragment {
    ArrayList<DLCat> mItems;
    RecyclerView mRecyclerView;
    public static AllCatsFragment newInstance(int tabID, ArrayList<DLCat> items) {
        AllCatsFragment allcatsFragment = new AllCatsFragment();
        allcatsFragment.mItems = items;
        Bundle args = new Bundle();
        args.putInt("id", tabID);
        allcatsFragment.setArguments(args);
        return allcatsFragment ;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("DLCatItems",mItems);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_cats_fragment,container,false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManagerWithSmoothScroller(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        if(savedInstanceState!=null) {
            mItems = (ArrayList<DLCat>) savedInstanceState.getSerializable("DLCatItems");
        }
        mRecyclerView.setAdapter(new DLCatAdapter(mItems,false));
    }

    private void initViews(View rootView){
        mRecyclerView = rootView.findViewById(R.id.RecyclerView);
    }
}
