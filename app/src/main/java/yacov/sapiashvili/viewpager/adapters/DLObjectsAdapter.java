package yacov.sapiashvili.viewpager.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.activitys.ElementDetailsActivity;
import yacov.sapiashvili.viewpager.model.DLObject;
import yacov.sapiashvili.viewpager.views.DLCatViewHolder;
import yacov.sapiashvili.viewpager.views.DLObjectViewHolder;

/**
 * Created by yaacovs on 30/12/2017.
 */

public class DLObjectsAdapter extends RecyclerView.Adapter<DLObjectViewHolder> {
    private final int DLCatID;
    ArrayList<DLObject> dlObjects;
    public DLObjectsAdapter(ArrayList<DLObject> dlObjects) {
        this.dlObjects = dlObjects;
        this.DLCatID = 0;
    }

    public DLObjectsAdapter(ArrayList<DLObject> dlObjects, int dlCatID) {
        this.dlObjects = dlObjects;
        this.DLCatID = dlCatID;

    }

    @Override
    public DLObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new DLObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DLObjectViewHolder holder, final int position) {
        holder.setTitle(dlObjects.get(position).getmTt());
        holder.setSubTitle(dlObjects.get(position).getSTt());
        holder.setImage(dlObjects.get(position).getIm());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ElementDetailsActivity.class);
                intent.putExtra("DLCatID",DLCatID);
                intent.putExtra("DLObjectID",dlObjects.get(position).getId());
                intent.putExtra("DLObjectImage",dlObjects.get(position).getIm());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dlObjects.size();
    }
}
