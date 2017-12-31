package yacov.sapiashvili.viewpager.views;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

/**
 * Created by yaacovs on 30/12/2017.
 */

public class LinearLayoutManagerWithSmoothScroller extends LinearLayoutManager {
    RecyclerView.SmoothScroller smoothScroller;
    Boolean mScrollWithOffset = false;
    public LinearLayoutManagerWithSmoothScroller(Context context,Boolean scrollWithOffset) {
        super(context, HORIZONTAL, false);//layoutManager scroll direction is HORIZONTAL by default
        smoothScroller = new TopSnappedSmoothScroller(context);
        this.mScrollWithOffset = scrollWithOffset;
    }

    public LinearLayoutManagerWithSmoothScroller(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state,
                                       int position) {
        smoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        if(mScrollWithOffset) {
            scrollToPositionWithOffset(position, 100);
            startSmoothScroll(smoothScroller);
        }
        else {
            startSmoothScroll(smoothScroller);
        }
    }

    @Override
    public void scrollToPositionWithOffset(int position, int offset) {
        super.scrollToPositionWithOffset(position, offset);
    }

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        public TopSnappedSmoothScroller(Context context) {
            super(context);

        }

        @Override
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return LinearLayoutManagerWithSmoothScroller.this
                    .computeScrollVectorForPosition(targetPosition);
        }

        @Override
        protected int getHorizontalSnapPreference() {
            return SNAP_TO_ANY;
        }

        @Override
        protected int getVerticalSnapPreference() {
            return SNAP_TO_START;
        }
    }
}