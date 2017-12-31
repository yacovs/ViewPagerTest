package yacov.sapiashvili.viewpager.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.activitys.ElementDetailsActivity;
import yacov.sapiashvili.viewpager.model.DLCat;
import yacov.sapiashvili.viewpager.model.DLObject;
import yacov.sapiashvili.viewpager.views.DLCatViewHolder;

/**
 * Created by yaacovs on 30/12/2017.
 */

public class DLCatAdapter extends RecyclerView.Adapter<DLCatViewHolder> {
    ArrayList<DLCat> mDlCats;
    Boolean mScrollWithOffset;
    public DLCatAdapter(ArrayList<DLCat> mDlCats ,Boolean mScrollWithOffset) {
        this.mDlCats = mDlCats;
        this.mScrollWithOffset = mScrollWithOffset;
    }
    @Override
    public DLCatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dlcatholder,parent,false);
        return new DLCatViewHolder(view);
    }
    @Override
    public void onBindViewHolder(DLCatViewHolder holder, int position) {
        holder.setTitle(mDlCats.get(position).getCTitle());
        if(mScrollWithOffset) {
            holder.setSnapDLObjectsAdapter(mDlCats.get(position).getmDLObject(), mDlCats.get(position).getmCatId());
        }else {
            holder.setSlideToFirstDLObjectsAdapter(mDlCats.get(position).getmDLObject(),mDlCats.get(position).getmCatId());
        }
    }
    @Override
    public int getItemCount() {
        return mDlCats.size();
    }

}
