package yacov.sapiashvili.viewpager.views;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;


import java.util.ArrayList;

import yacov.sapiashvili.viewpager.R;
import yacov.sapiashvili.viewpager.adapters.DLObjectsAdapter;
import yacov.sapiashvili.viewpager.model.DLObject;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;


/**
 * Created by yaacovs on 30/12/2017.
 */

public class DLCatViewHolder extends RecyclerView.ViewHolder {

    TextView mDLCatTitle;
    RecyclerView mRecyclerView;

    public DLCatViewHolder(View itemView) {

        super(itemView);
        mDLCatTitle = itemView.findViewById(R.id.DLCatTitle);
        mRecyclerView = itemView.findViewById(R.id.DLCatRecyclerView);
    }
    public void setTitle(String title){
        mDLCatTitle.setText(title);
    }
    public void setSlideToFirstDLObjectsAdapter(ArrayList<DLObject> dlObjects, int DLCatID){
        final LinearLayoutManagerWithSmoothScroller smoothScroller = new LinearLayoutManagerWithSmoothScroller(itemView.getContext(),false);
        mRecyclerView.setLayoutManager(smoothScroller);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState== SCROLL_STATE_IDLE){
                    int firstVisibleItemPosition = smoothScroller.findFirstVisibleItemPosition();
                    int lastVisibleItemPosition = smoothScroller.findLastVisibleItemPosition();
                    if(firstVisibleItemPosition==0)
                        mRecyclerView.smoothScrollToPosition(firstVisibleItemPosition);
                    else if(lastVisibleItemPosition==mRecyclerView.getAdapter().getItemCount()){
                        mRecyclerView.smoothScrollToPosition(lastVisibleItemPosition);
                    }else{
                        mRecyclerView.smoothScrollToPosition(firstVisibleItemPosition++);
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(itemView.getContext(), resId);
        mRecyclerView.setLayoutAnimation(animation);
        mRecyclerView.setAdapter(new DLObjectsAdapter(dlObjects,DLCatID));
    }
    public void setSnapDLObjectsAdapter(ArrayList<DLObject> dlObjects, int DLCatID){
        final LinearLayoutManager smoothScroller = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(smoothScroller);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState== SCROLL_STATE_IDLE){
                    int firstVisibleItemPosition = smoothScroller.findFirstVisibleItemPosition();
                    int lastVisibleItemPosition = smoothScroller.findLastVisibleItemPosition();
                    int midDelta = ((lastVisibleItemPosition - firstVisibleItemPosition)/2)+1;
                    int midPosition = lastVisibleItemPosition -midDelta;
                    if(firstVisibleItemPosition==0){
                        smoothScroller.scrollToPositionWithOffset(firstVisibleItemPosition,0);
                    }
                    else if(midPosition>=firstVisibleItemPosition && midPosition<lastVisibleItemPosition)
                        smoothScroller.scrollToPositionWithOffset(midPosition,120);

                    else {
                        smoothScroller.scrollToPositionWithOffset(lastVisibleItemPosition,0);
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(itemView.getContext(), resId);
        mRecyclerView.setLayoutAnimation(animation);
        mRecyclerView.setAdapter(new DLObjectsAdapter(dlObjects,DLCatID));
    }
}
